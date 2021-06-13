package tn.isi.imd.inventoryservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.isi.imd.inventoryservice.model.Inventory;
import tn.isi.imd.inventoryservice.repository.InventoryRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    @GetMapping("/{skuCode}")
    Boolean isInStock(@PathVariable String skuCode ){
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(()-> new RuntimeException("cann not find product with sku code = "+skuCode));
        return inventory.getStock()>0;
    }

}
