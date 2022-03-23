package com.car.inventory.controller;

import com.car.inventory.domain.Inventory;
import com.car.inventory.exception.CustomException;
import com.car.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v1/inventories")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping
    private List<Inventory> getInventory() {
        return inventoryService.inventoryList();
    }

    @GetMapping("/{identifier}")
    private List<Inventory> getCarByIdentifier(@PathVariable("identifier") int identifier) {
        return inventoryService.getByIdentifier(identifier);
    }

    @DeleteMapping("/{identifier}")
    private void deleteInInventory(@PathVariable ("identifier")int identifier){
        inventoryService.deleteByIdentifier(identifier);
    }

    @PostMapping
    private void newCarInInventory(@RequestBody Inventory inventory) throws CustomException {
        inventoryService.save(inventory);
    }
    @PutMapping
    private void updateCarInventory(@RequestBody Inventory inventory) throws CustomException{
        inventoryService.save(inventory);
    }
}
