package main.java.com.library.dao;

import main.java.com.library.models.Category;

import java.util.List;

public interface CategoryDao {
    Category addCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(long id);
    Category getCategorybyId(long id);
    List<Category> getAllCategory();
}
