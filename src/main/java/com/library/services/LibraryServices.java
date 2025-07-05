package main.java.com.library.services;

import main.java.com.library.exceptions.*;
import main.java.com.library.models.*;

import java.util.List;
import java.util.Map;

public interface LibraryServices {
    User addUser(User user);
    User updateUser(User user) throws UserNotFoundException;
    void deleteUser(long id) throws UserNotFoundException;
    User getUserbyId(long id) throws UserNotFoundException;

    Category addCategory(Category category);
    Category updateCategory(Category category) throws CategoryNotFoundException;
    void deleteCategory(long id) throws CategoryNotFoundException;
    Category getCategorybyId(long id) throws CategoryNotFoundException;
    List<Category> getAllCategory();

    Purchase addPurchase(Purchase purchase) ;
    Purchase updatePurchase(Purchase purchase) throws PurchaseNotFoundException;
    void deletePurchase(long id) throws PurchaseNotFoundException;
    Purchase getPurchasebyId(long id) throws PurchaseNotFoundException;
    List<Purchase> getPurchasesFromUser(User user);

    Restaurant addRestaurant(Restaurant restaurant) ;
    Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;
    void deleteRestaurant(long id) throws RestaurantNotFoundException;
    Restaurant getRestaurantbyId(long id) throws RestaurantNotFoundException;
    List<Restaurant> getAllRestaurant() throws RestaurantNotFoundException;

    FoodItem addFoodItem(FoodItem foodItem) ;
    FoodItem updateFoodItem(FoodItem foodItem) throws FoodItemNotFoundException;
    void deleteFoodItem(long id) throws FoodItemNotFoundException;
    FoodItem getFoodItembyId(long id) throws FoodItemNotFoundException;
    List<FoodItem> getAllItem();
    Map<Category,FoodItem> getItemByCategory();
    List<FoodItem> getFoodItemFromRestaurant(Restaurant restaurant);
    List<Category> getCategoriesFromRestaurant(Restaurant restaurant);
}
