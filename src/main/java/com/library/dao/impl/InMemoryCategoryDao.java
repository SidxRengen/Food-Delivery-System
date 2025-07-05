package main.java.com.library.dao.impl;

import main.java.com.library.dao.CategoryDao;
import main.java.com.library.models.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryCategoryDao implements CategoryDao {
    private final Map<Long,Category> categories = new HashMap<>();
    private final AtomicLong ID = new AtomicLong(1);
    @Override
    public Category addCategory(Category category) {
        long id = ID.getAndIncrement();
        category.setId(id);
        categories.put(id, category);
        return category;
    }

    @Override
    public Category updateCategory(Category category) {
        if (categories.containsKey(category.getId())){
            categories.put(category.getId(),category);
            return category;
        }
        return null;
    }

    @Override
    public Category getCategorybyId(long id) {
        if (categories.containsKey(id)){
            return categories.get(id);
        }
        return null;
    }

    @Override
    public List<Category> getAllCategory() {
        return new ArrayList<>(categories.values());
    }

    @Override
    public void deleteCategory(long id) {
        categories.remove(id);
    }
}
