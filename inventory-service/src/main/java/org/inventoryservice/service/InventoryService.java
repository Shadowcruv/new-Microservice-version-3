package org.inventoryservice.service;

import lombok.RequiredArgsConstructor;
import org.inventoryservice.respository.InventoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStock(String skuCode, Integer quantity){
        //Find an inventory for a given skuCode where quantity >= 0;
        // the thread below is used to simulate a slow/poor network connection
//        try {
//            Thread.sleep(6000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
