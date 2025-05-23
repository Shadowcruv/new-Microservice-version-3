package org.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import org.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, Integer quantity){
        return inventoryService.isInStock(skuCode, quantity);
    }


}
