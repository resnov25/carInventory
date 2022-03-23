package com.cardatabase.car.service;

import com.cardatabase.car.domain.Car;
import com.cardatabase.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<Car> carList(String maker) {
        if (maker != null){
            return getCarByMaker(maker);
        }
        return carRepository.findAll();
    }

    public List<Car> getCarByMaker(String maker) {
        return carRepository.findByMakerContaining(maker);
    }

    public Car getCarById(int identifier){
        return carRepository.findByIdentifier(identifier).orElseThrow(() ->new IllegalStateException("No se encontro el coche"));
    }

    public Car save(Car car){
        Optional<Car> carOptional = carRepository.findByModelAndMakerAndYear(car.getModel(), car.getMaker(), car.getYear());
        if (carOptional.isPresent()){
            System.out.println("El coche ya existe");
            return carRepository.getById(car.getId());
        }else{
            System.out.println("Guardado con exito");
            return carRepository.save(car);
        }
    }

    public void deleteCar(String model) {
        carRepository.deleteByModel(model);
    }

    public void updateCar(Car car, int id) {

        carRepository.findById(id).map(car1 -> {
            car1.setMaker(car.getMaker());
            car1.setYear(car.getYear());
            car1.setModel(car.getModel());

            return carRepository.save(car1);

        }).orElseGet(() -> {
            return carRepository.save(car);
        });


    }
}
