package com.service;

import com.dao.ProductDao;
import com.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductSrvImpl implements ProductService{
    @Autowired private ProductDao productDao;

    @Override
    public Product saveProduct (Product product) {
        System.out.println("Prodcut service "+product.toString());
        return productDao.save(product);
    }

    @Override
    public List <Product> getTotalproduct () {
        return productDao.findAll();
    }
}
