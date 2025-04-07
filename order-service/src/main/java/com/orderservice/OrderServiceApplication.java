package com.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;


//We woundn't be using openFeign again because of the devs didn't continue it's upgrade so they suggested to switch to rest client
//@EnableFeignClients  to Configure the application to be able to use feignClient
@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);


    }
}
