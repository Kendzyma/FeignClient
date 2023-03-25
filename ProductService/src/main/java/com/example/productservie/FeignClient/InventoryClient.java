package com.example.productservie.FeignClient;

import com.example.inventoryservice.model.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/api/v1")
    List<Products> getAllProducts();

    @PutMapping("/api/v1")
    Products updateProduct(@RequestBody Products products);
}
