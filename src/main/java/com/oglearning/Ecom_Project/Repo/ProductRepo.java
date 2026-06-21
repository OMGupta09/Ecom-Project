package com.oglearning.Ecom_Project.Repo;

import com.oglearning.Ecom_Project.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
