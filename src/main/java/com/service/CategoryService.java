package com.service;

import com.entity.Category;

import java.util.List;

public interface CategoryService {

    public List <Category> getAllProduct();

    Category addCategory (Category category);
    List<Category> totalCategories();
}
