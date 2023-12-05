package com.example.wizer_code_challange.serviveImpl;

import com.example.wizer_code_challange.entity.Book;
import com.example.wizer_code_challange.entity.Category;
import com.example.wizer_code_challange.repository.CategoryRepository;
import com.example.wizer_code_challange.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    @Override
    @Transactional
    public Category addCategory(Category category) {
        if (category != null) {
            List<Book> books = (List<Book>) category.getBooks();
            if (books != null) {
                for (Book book : books) {
                    book.setCategory(category);
                }
            }

            return categoryRepository.save(category);
        }

        throw new IllegalArgumentException("Category cannot be null");
    }

    @Override
    @Transactional
    public Category editCategory(Long categoryId, Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(categoryId).orElse(null);

        if (existingCategory != null) {
            existingCategory.setCategoryName(updatedCategory.getCategoryName());
            return categoryRepository.save(existingCategory);
        }

        return null;
    }

    @Override
    @Transactional
    public boolean deleteCategory(Long categoryId) {
        Category categoryToDelete = categoryRepository.findById(categoryId).orElse(null);

        if (categoryToDelete != null) {
            categoryRepository.delete(categoryToDelete);
            return true;
        }

        return false;
    }

}
