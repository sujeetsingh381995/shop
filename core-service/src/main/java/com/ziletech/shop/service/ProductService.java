package com.ziletech.shop.service;

import com.ziletech.shop.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    Product saveProduct(Product product);

    Product getById(long id);
}
