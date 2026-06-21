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
    ProductRepo repo;

    public List<Product> getAllProducts()
    {
        return repo.findAll();
    }

    public Product getProduct(int id)
    {
        return repo.findById(id).orElse(new Product());
    }

    public Product createProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageDate(imageFile.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(Product product)
    {
        return repo.save(product);
    }

    public void deleteProduct(int id)
    {
        repo.deleteById(id);
    }

}
