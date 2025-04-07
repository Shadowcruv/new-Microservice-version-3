package com.orderservice.tests;


import com.orderservice.tests.stubs.InventoryClientStub;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;
import org.assertj.core.api.Assertions;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // you want the test to run on a random port and not thesame port the application is using.
@AutoConfigureWireMock(port = 0)  //configure all the wiremock related classes
public class OrderServiceApplicationTests {

    //intialize a mysql test container
    //using the annotation we don't need to explicitly specify the uri details in an application properties, springboot will automatically inject the uri login details for mysql
    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:lts");

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mySQLContainer.start();
    }


    //Ways to test our interation with an externam client e.g using openfeign to make a call
    //1. Using Mockito.  But here what we will be mocking is just the method whereby it will return the response you want, you wouldn't actually testing the http interaction.
    //2. Using WireMock. In here we will actually be testing the http Connection
//    @Test
//    void shouldCreateOrder(){
//        String submitOrderJson = """
//                {
//                  "skuCode" : "samsung_test1",
//                  "price" : 58000,
//                  "quantity" : 2
//                }
//                """;
//
//        InventoryClientStub.stubInventoryCall("samsung_test1", 2);
//
//
//        String responseBodyString = RestAssured.given()
//                .contentType("application/json")
//                .body(submitOrderJson)
//                .when()
//                .post("api/v1/order")
//                .then()
//                .log().all()
//                .statusCode(201)
//                .extract()
//                .body().asString();
//
//        Assertions.assertThat(responseBodyString).isEqualTo("Order Placed Successfully");
//        // you can  say this above or this below
//
//        // assertThat(responseBodyString, Matchers.is(" Order Placed Successfully"));
//    }
}
