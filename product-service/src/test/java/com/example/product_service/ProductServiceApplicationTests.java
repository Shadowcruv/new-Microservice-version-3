package com.example.product_service;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // you want the test to run on a random port and not thesame port the application is using
class ProductServiceApplicationTests {

	//intialize a mongodb test container
	//using the annotation we don't need to explicitly specify the uri details in an application properties, springboot will automatically inject the uri login details for mongodb
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongodb/mongodb-community-server:7.0.5-ubi8");

	//what this would do is that whenever an application is running, it is going to inject the port it is running on in that variable port.
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		//you wouldn't include any port(i.e 8081 or any) here because you are using a random port
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	static {
		//to start the test container before running the test.
		mongoDBContainer.start();
	}

//	@Test
//	void shouldCreateProduct() {
//		String requestBody = """
//					{
//					   "name": "Test FlyEmirates",
//					   "description": "A Big White Plane",
//					   "price": 400
//					}
//				""";
//
//		RestAssured.
//				given()
//				.contentType("application/json")
//				.body(requestBody)
//				.when()
//				.post("/api/v1/product/create")
//				.then()
//				.statusCode(201)
//				.body("id", Matchers.notNullValue())
//				.body("name", Matchers.equalTo("Test FlyEmirates"))
//				.body("description", Matchers.equalTo("A Big White Plane"))
//				.body("price", Matchers.equalTo(400));
//	}

}
