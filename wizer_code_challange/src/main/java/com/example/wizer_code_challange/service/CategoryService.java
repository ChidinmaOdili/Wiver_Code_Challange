package com.example.wizer_code_challange.service;

import com.example.wizer_code_challange.entity.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long categoryId);

    Category addCategory(Category category);

    Category editCategory(Long categoryId, Category updatedCategory);

    boolean deleteCategory(Long categoryId);
}


