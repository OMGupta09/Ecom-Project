package com.oglearning.Ecom_Project.Controller;

import com.oglearning.Ecom_Project.Model.Product;
import com.oglearning.Ecom_Project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String greet()
    {
        return "Hello World!";
    }

    @GetMapping("/products")
    public List<Product> getAllproducts()
    {
      return  service.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable int id)
    {
        return service.getProduct(id);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestPart Product product,
                                 @RequestPart MultipartFile imageFile)
    {
        return service.createProduct(product,imageFile);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product)
    {
        return service.updateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id)
    {
        service.deleteProduct(id);
    }
}
