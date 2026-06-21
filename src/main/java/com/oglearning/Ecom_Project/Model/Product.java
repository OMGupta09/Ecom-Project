package com.oglearning.Ecom_Project.Model;

import lombok.Data;

import java.math.BigDecimal;

public class Product {

    private int id;
    private String name;
    private String desc;
    private String brand;
    private BigDecimal price;
    private String category;
    private Data releaseDate;
    private boolean available;
    private int quantity;

}