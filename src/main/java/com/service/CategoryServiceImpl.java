package com.service;

import com.dao.CategoryDao;
import com.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired private CategoryDao categoryDao;

    @Override
    public List <Category> getAllProduct () {
        return categoryDao.findAll();
    }

    @Override
    public Category addCategory (Category category) {
        return categoryDao.save(category);

    }

    @Override
    public List <Category> totalCategories () {
        return categoryDao.findAll();
    }
}
