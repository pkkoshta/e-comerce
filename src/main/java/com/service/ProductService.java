package com.service;

import com.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List <Product> getTotalproduct();
}
