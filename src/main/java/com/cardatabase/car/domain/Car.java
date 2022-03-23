package com.cardatabase.car.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car", schema = "car")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Car {
    @Id
    @Column
    private int id;
    @Column
    private String model;
    @Column
    private String year;
    @Column
    private String maker;
    @Column
    private int identifier;

    public int getId() {
        return id;
    }

}
