package com.ziletech.shop.controller;

import com.ziletech.shop.entity.Product;
import com.ziletech.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product saveProduct = productService.saveProduct(product);
        return new ResponseEntity<>(saveProduct, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id")long id){
        Product product = productService.getById(id);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }


}
