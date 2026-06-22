package com.oglearning.Ecom_Project.Service;

import com.oglearning.Ecom_Project.Model.Product;
import com.oglearning.Ecom_Project.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    // Get all products
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // Get one product
    public Product getProduct(int id) {

        return repo.findById(id)
                .orElse(new Product());
    }

    // Create product
    public Product createProduct(
            Product product,
            MultipartFile imageFile
    ) throws IOException {

        product.setImageName(
                imageFile.getOriginalFilename());

        product.setImageType(
                imageFile.getContentType());

        product.setImageData(
                imageFile.getBytes());

        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageType(imageFile.getContentType());
        product.setImageName(imageFile.getOriginalFilename());
        repo.save(product);
        return product;
    }

    // Delete product
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}