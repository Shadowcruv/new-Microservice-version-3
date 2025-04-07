package org.inventoryservice.tests;


import io.restassured.RestAssured;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class InventoryServiceApplicationTest {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:lts");

    @LocalServerPort
    private Integer port;

    static {
        mySQLContainer.start();
    }

    @BeforeEach
    void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

//    @Test
//    void checkInventory(){
//        Boolean response = RestAssured.given()
//                .when()
//                .get("api/v1/inventory?skuCode=iphone_15&quantity=1")
//                .then()
//                .log().all()
//                .statusCode(200)
//                .extract().response().as(Boolean.class);
//
//        Assertions.assertTrue(response);
//
//        Boolean secondResponse = RestAssured.given()
//                .when()
//                .get("api/v1/inventory?skuCode=iphone_15&quantity=200")
//                .then()
//                .log().all()
//                .statusCode(200)
//                .extract().response().as(Boolean.class);
//
//        Assertions.assertFalse(secondResponse);
//
//
//    }
}
