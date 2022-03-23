package com.cardatabase.car.controller;


import com.cardatabase.car.domain.Car;
import com.cardatabase.car.domain.Inventory;
import com.cardatabase.car.service.CarService;
import com.cardatabase.car.service.InventoryService;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/cars")
@RestController
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    private List<Car> getAllCars(@RequestParam(required = false) String maker) {
        return carService.carList(maker);
    }

    @PostMapping
    private void saveCar(@RequestBody Car car) {
        carService.save(car);
    }

    @DeleteMapping
    private void deleteCar(@PathVariable("model") String model) {
        carService.deleteCar(model);
    }

    @PutMapping
    private void updateCar(@RequestBody Car car, @PathVariable("id") int id) {

        carService.updateCar(car, id);
    }

    @GetMapping("/{identifier}")
    private Car getCarById(@PathVariable("identifier") int identifier) {
        return carService.getCarById(identifier);
    }

    //------------------------------------------------------------------------------------------------------------------


}
