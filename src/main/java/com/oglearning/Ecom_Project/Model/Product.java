package com.oglearning.Ecom_Project.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String desc;

    private String brand;

    private BigDecimal price;

    private String category;

    private LocalDate releaseDate;

    private boolean available;

    // quantity -> stockQuantity
    private int stockQuantity;

    private String imageName;

    private String imageType;

    @Lob
    private byte[] imageData;
}