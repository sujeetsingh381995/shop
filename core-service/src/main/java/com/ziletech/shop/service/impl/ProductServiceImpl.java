package com.ziletech.shop.service.impl;

import com.ziletech.shop.entity.Product;
import com.ziletech.shop.repository.ProductRepository;
import com.ziletech.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(long id) {
        return productRepository.findById(id).orElse(null);
    }
}
