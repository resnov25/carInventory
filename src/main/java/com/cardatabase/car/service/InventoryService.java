package com.cardatabase.car.service;

import com.cardatabase.car.domain.Car;
import com.cardatabase.car.domain.Inventory;
import com.cardatabase.car.exception.CustomException;
import com.cardatabase.car.repository.CarRepository;
import com.cardatabase.car.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    CarRepository carRepository;

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
        Optional<Car> carOptional = carRepository.findByIdentifier(inventory.getIdentifier());
        if (carOptional.isPresent()) {
            System.out.println("Guardado con exito");
            return inventoryRepository.save(inventory);
        } else {
            throw new CustomException("El carro no existe en el inventario");
        }

    }

    public void updateCarInInventory(Inventory inventory, int identifier) throws CustomException {
        Optional<Car> carOptional = carRepository.findByIdentifier(inventory.getIdentifier());
        if (carOptional.isPresent()) {
            inventoryRepository.findById(identifier).map(inventory1 -> {
                inventory1.setPrice(inventory.getPrice());
                inventory1.setQuantity(inventory.getQuantity());

                return inventoryRepository.save(inventory1);
            });
        }else{
            throw new CustomException("El coche no existe");
        }
    }
}
