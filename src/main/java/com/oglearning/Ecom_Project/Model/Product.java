package com.oglearning.Ecom_Project.Model;

import lombok.Data;

public class Product {

    private int id;
    private String name;
    private String desc;
    private String brand;
    private int price;
    private String category;
    private Data releaseDate;
    private boolean available;
    private int quantity;

}