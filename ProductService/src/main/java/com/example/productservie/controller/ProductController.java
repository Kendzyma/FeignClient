package com.example.productservie.controller;

import com.example.inventoryservice.model.Products;
import com.example.productservie.Service.ProductService;
import com.example.productservie.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")

public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping()
    public ResponseEntity<?> addProduct(@RequestBody Products product){
        return ResponseEntity.ok(productService.buyProduct(product));
    }
}
