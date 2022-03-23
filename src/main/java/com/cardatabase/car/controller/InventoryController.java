package com.cardatabase.car.controller;

import com.cardatabase.car.domain.Inventory;
import com.cardatabase.car.exception.CustomException;
import com.cardatabase.car.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
public class InventoryController {
    @Autowired
    InventoryService inventoryService;



    @GetMapping("/inventory")
    private List<Inventory> getInventory() {
        return inventoryService.inventoryList();
    }

    @GetMapping("/inventory/{identifier}")
    private List<Inventory> getCarByIdentifier(@PathVariable("identifier") int identifier) {
        return inventoryService.getByIdentifier(identifier);
    }

    @DeleteMapping("/inventory/delete/{identifier}")
    private void deleteInInventory(@PathVariable ("identifier")int identifier){
        inventoryService.deleteByIdentifier(identifier);
    }

    @PostMapping("/inventory/newCar")
    private void newCarInInventory(@RequestBody Inventory inventory) throws CustomException {
        inventoryService.save(inventory);
    }
    @PutMapping("/updateCarInventory/{identifier}")
    private void updateCarInventory(@RequestBody Inventory inventory, @PathVariable("identifier") int identifier) throws CustomException{
        inventoryService.updateCarInInventory(inventory, identifier);
    }
}
