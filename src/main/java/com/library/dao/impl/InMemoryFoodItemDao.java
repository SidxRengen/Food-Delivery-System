package main.java.com.library.dao.impl;

import main.java.com.library.dao.FoodItemDao;
import main.java.com.library.models.Category;
import main.java.com.library.models.FoodItem;
import main.java.com.library.models.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryFoodItemDao  implements FoodItemDao {
    private final Map<Long, FoodItem> foodItems = new HashMap<>();
    private final AtomicLong ID = new AtomicLong(1);

    @Override
    public FoodItem addFoodItem(FoodItem foodItem) {
        long id = ID.getAndIncrement();
        foodItem.setId(id);
        foodItems.put(id, foodItem);
        return foodItem;
    }

    @Override
    public FoodItem getFoodItembyId(long id) {
        return foodItems.get(id);
    }

    @Override
    public FoodItem updateFoodItem(FoodItem foodItem) {
        if (foodItems.containsKey(foodItem.getId())){
            foodItems.put(foodItem.getId(),foodItem);
            return foodItem;
        }
        return null;
    }

    @Override
    public List<FoodItem> getAllItem() {
        return new ArrayList<>(foodItems.values());
    }

    @Override
    public void deleteFoodItem(long id) {
        foodItems.remove(id);
    }

    @Override
    public Map<Category, FoodItem> getItemByCategory() {
        Map<Category,FoodItem> m = new HashMap<>();
        for (FoodItem foodItem: foodItems.values()){
            m.put(foodItem.getCategory(),foodItem);
        }
        return m;
    }

    @Override
    public List<Category> getCategoriesFromRestaurant(Restaurant restaurant) {
        List<Category> list = new ArrayList<>();
        for (FoodItem foodItem: foodItems.values()){
            if (foodItem.getRestaurant()==restaurant){
                list.add(foodItem.getCategory());
            }
        }
        return list;
    }

    @Override
    public List<FoodItem> getFoodItemFromRestaurant(Restaurant restaurant) {
        List<FoodItem> list = new ArrayList<>();
        for (FoodItem foodItem: foodItems.values()){
            if (foodItem.getRestaurant()==restaurant){
                list.add(foodItem);
            }
        }
        return list;
    }
}
