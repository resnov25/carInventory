package com.car.inventory.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarResponse {


    private int id;

    private String model;

    private String year;

    private String maker;

    private int identifier;


}
