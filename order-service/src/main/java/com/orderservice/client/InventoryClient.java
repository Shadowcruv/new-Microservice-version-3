package com.orderservice.client;


import groovy.util.logging.Slf4j;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;




//We woundn't be using openFeign again because of the devs didn't continue it's upgrade so they suggested to switch to rest client
//@FeignClient(value = "inventory", url = "${inventory.url}")
@Slf4j
public interface InventoryClient {

    @GetExchange("/api/v1/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);


    default boolean fallbackMethod(String code, Integer quantity, Throwable throwable){
        System.out.println("Cannot get inventory for skucode: " + code + " failure reason: " +  throwable.getMessage());
        return false;
    }

}
