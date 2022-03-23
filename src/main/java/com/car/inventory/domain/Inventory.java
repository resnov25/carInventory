package com.car.inventory.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventory", schema = "inventory")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Inventory {
    @Id
    @Column
    private int id;

    @Column
    private int identifier;

    @Column
    private int quantity;

    @Column
    private int price;
}
