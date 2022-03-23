package com.cardatabase.car.repository;

import com.cardatabase.car.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByMakerContaining(String maker);

    Optional<Car> findByModelAndMakerAndYear(String model, String maker, String year);

    Optional<Car> findByIdentifier(int identifier);

    void deleteByModel(String model);


}
