package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("api/v1")
@RestController
public class InventoryController {

    @GetMapping
    public List<Products> productsList(){
        return new ArrayList<>(List.of(new Products("Milo",34.6,10),
                new Products("bournvita",21.2,2),
                new Products("Milk",43.2,5)));
    }

    @PutMapping()
    public Products updateProduct(@RequestBody Products products){
       return productsList().stream().
               filter(products1 -> products1.getProductName().equals(products.getProductName())).findFirst()
               .map(product1 -> {
                   product1.setTotalNumber(product1.getTotalNumber() - products.getTotalNumber());
                   return product1;
               }).orElseThrow(()-> new RuntimeException("Error Updating Product"));
    }
}
