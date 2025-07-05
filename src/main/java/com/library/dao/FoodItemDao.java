package main.java.com.library.dao;

import main.java.com.library.models.Category;
import main.java.com.library.models.FoodItem;
import main.java.com.library.models.Restaurant;

import java.util.List;
import java.util.Map;

public interface FoodItemDao {
    FoodItem addFoodItem(FoodItem foodItem);
    FoodItem updateFoodItem(FoodItem foodItem);
    void deleteFoodItem(long id);
    FoodItem getFoodItembyId(long id);
    List<FoodItem> getAllItem();
    Map<Category,FoodItem> getItemByCategory();
    List<FoodItem> getFoodItemFromRestaurant(Restaurant restaurant);
    List<Category> getCategoriesFromRestaurant(Restaurant restaurant);
}
