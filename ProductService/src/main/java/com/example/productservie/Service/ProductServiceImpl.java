package com.example.productservie.Service;

import com.example.inventoryservice.model.Products;
import com.example.productservie.FeignClient.InventoryClient;
import com.example.productservie.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private InventoryClient inventoryClient;
    @Override
    public Products buyProduct(Products product) {
        List<Products> productList = inventoryClient.getAllProducts();

        Products newProduct = productList.stream().filter(products -> products.getProductName().equals(product.getProductName())).findFirst()
                .orElseThrow(() -> new RuntimeException("Product does not exist"));

        if (newProduct.getTotalNumber() >= product.getTotalNumber()) {
            return inventoryClient.updateProduct(product);
        }
        else {
            throw new RuntimeException("Product Out of stock!!!");
        }

    }
}
