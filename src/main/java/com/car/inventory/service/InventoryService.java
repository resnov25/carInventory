package com.car.inventory.service;

import com.car.inventory.domain.Car;
import com.car.inventory.domain.Inventory;
import com.car.inventory.exception.CustomException;
import com.car.inventory.repository.InventoryRepository;
import com.car.inventory.response.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    RestTemplate restTemplate;

    public List<Inventory> inventoryList() {
        return inventoryRepository.findAll();
    }

    public List<Inventory> getByIdentifier(int identifier) {
        return inventoryRepository.findByIdentifier(identifier);
    }

    public void deleteByIdentifier(int identifier) {
        inventoryRepository.deleteByIdentifier(identifier);
    }

    public Inventory save(Inventory inventory) throws CustomException {

        CarResponse carResponse = restTemplate.getForObject("http://localhost:8081/api/v1/cars/{identifier}", CarResponse.class, inventory.getIdentifier());
        if(carResponse == null){
            throw new CustomException("El carro no existe en el inventario");
        }
        return inventoryRepository.save(inventory);
    }



    }

