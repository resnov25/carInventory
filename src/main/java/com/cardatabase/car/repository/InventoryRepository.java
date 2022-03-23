package com.cardatabase.car.repository;

import com.cardatabase.car.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {


    List<Inventory> findByIdentifier(int identifier);
    void deleteByIdentifier(int identifier);

}
