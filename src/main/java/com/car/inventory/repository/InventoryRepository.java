package com.car.inventory.repository;

import com.car.inventory.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {


    List<Inventory> findByIdentifier(int identifier);
    void deleteByIdentifier(int identifier);

}
