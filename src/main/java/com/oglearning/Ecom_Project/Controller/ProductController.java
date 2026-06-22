package com.oglearning.Ecom_Project.Controller;

import com.oglearning.Ecom_Project.Model.Product;
import com.oglearning.Ecom_Project.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    @Autowired
    private ProductService service;

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    // Get a single product
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable int id) {
        return service.getProduct(id);
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageById(@PathVariable int id) {

        Product product = service.getProduct(id);

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(product.getImageData());
    }

    // Add a product
    @PostMapping("/product")
    public Product createProduct(
            @RequestPart("product") Product product,

            @RequestPart("imageFile")
            MultipartFile imageFile

    ) throws IOException {

        return service.createProduct(product, imageFile);
    }

//    // Update a product
//    @PutMapping("/product/{id}")
//    public Product updateProduct(
//            @PathVariable int id,
//
//            @RequestPart("product")
//            Product product,
//
//            @RequestPart(value = "imageFile", required = false)
//            MultipartFile imageFile
//
//    ) throws IOException {
//
//        product.setId(id);
//
//        return service.updateProduct(id, product, imageFile);
//    }

    // Delete a product
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product product=service.getProduct(id);
        if(product != null)
        {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Product Not Found" , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product,
                                                @RequestPart(value = "imageFile" , required = false) MultipartFile imageFile) throws IOException {
        Product p1=service.updateProduct(id,product,imageFile);
        if(p1 != null)
        {
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to Update", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String keyword)
    {
        List<Product> products=service.searchProducts(keyword);

        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}