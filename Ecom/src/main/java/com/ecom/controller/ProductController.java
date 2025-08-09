package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecom.EcomApplication;
import com.ecom.entity.Product;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final EcomApplication ecomApplication;

    @Autowired
    private ProductService service;

    ProductController(EcomApplication ecomApplication) {
        this.ecomApplication = ecomApplication;
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        Product product2 = service.saveProduct(product);
        if (product2 != null) {
            return new ResponseEntity<>(product2, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Error in adding product", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = service.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable int id) {
        Product product = service.findProductById(id);
        if (product.getId() != 0) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<?> editProduct(@RequestBody Product product) {
        Product result = service.findProductById(product.getId());
        if (result.getId() != 0) {
            Product edit = service.saveProduct(product);
            return new ResponseEntity<>(edit, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Invalid product Id", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable int id) {
        Product result = service.findProductById(id);
        if (result.getId() != 0) {
            service.deleteProductById(id);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Invalid Product Id", HttpStatus.BAD_REQUEST);
        }
    }
}
