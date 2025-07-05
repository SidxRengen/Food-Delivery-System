package main.java.com.library.services;

import main.java.com.library.dao.*;
import main.java.com.library.exceptions.*;
import main.java.com.library.models.*;

import java.util.List;
import java.util.Map;

public class LibraryServicesImpl implements LibraryServices{
    private final UserDao userDao;
    private final RestaurantDao restaurantDao;
    private final CategoryDao categoryDao;
    private final PurchaseDao purchaseDao;
    private final FoodItemDao foodItemDao;

    public LibraryServicesImpl(UserDao userDao, RestaurantDao restaurantDao, CategoryDao categoryDao, PurchaseDao purchaseDao, FoodItemDao foodItemDao) {
        this.categoryDao = categoryDao;
        this.restaurantDao = restaurantDao;
        this.purchaseDao = purchaseDao;
        this.userDao = userDao;
        this.foodItemDao = foodItemDao;
    }

    @Override
    public List<Restaurant> getAllRestaurant() throws RestaurantNotFoundException {
        return restaurantDao.getAllRestaurant();
    }

    @Override
    public List<FoodItem> getFoodItemFromRestaurant(Restaurant restaurant) {
        return foodItemDao.getFoodItemFromRestaurant(restaurant);
    }

    @Override
    public List<Category> getCategoriesFromRestaurant(Restaurant restaurant) {
        return foodItemDao.getCategoriesFromRestaurant(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        return restaurantDao.updateRestaurant(restaurant);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantDao.addRestaurant(restaurant);
    }

    @Override
    public Map<Category, FoodItem> getItemByCategory() {
        return foodItemDao.getItemByCategory();
    }

    @Override
    public FoodItem updateFoodItem(FoodItem foodItem) throws FoodItemNotFoundException {
        return foodItemDao.updateFoodItem(foodItem);
    }

    @Override
    public FoodItem addFoodItem(FoodItem foodItem) {
        return foodItemDao.addFoodItem(foodItem);
    }

    @Override
    public Purchase updatePurchase(Purchase purchase) throws PurchaseNotFoundException {
        return purchaseDao.updatePurchase(purchase);
    }

    @Override
    public Purchase addPurchase(Purchase purchase) {
        return purchaseDao.addPurchase(purchase);
    }

    @Override
    public List<FoodItem> getAllItem() {
        return foodItemDao.getAllItem();
    }

    @Override
    public List<Purchase> getPurchasesFromUser(User user) {
        return purchaseDao.getPurchasesFromUser(user);
    }

    @Override
    public void deleteCategory(long id) throws CategoryNotFoundException {
        categoryDao.deleteCategory(id);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }

    @Override
    public Category getCategorybyId(long id) throws CategoryNotFoundException {
        return categoryDao.getCategorybyId(id);
    }

    @Override
    public Category updateCategory(Category category) throws CategoryNotFoundException {
        return categoryDao.updateCategory(category);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException {
        return userDao.updateUser(user);
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public FoodItem getFoodItembyId(long id) throws FoodItemNotFoundException {
        return foodItemDao.getFoodItembyId(id);
    }

    @Override
    public Purchase getPurchasebyId(long id) throws PurchaseNotFoundException {
        return purchaseDao.getPurchasebyId(id);
    }

    @Override
    public Restaurant getRestaurantbyId(long id) throws RestaurantNotFoundException {
        return restaurantDao.getRestaurantbyId(id);
    }

    @Override
    public User getUserbyId(long id) throws UserNotFoundException {
        return userDao.getUserbyId(id);
    }

    @Override
    public void deleteFoodItem(long id) throws FoodItemNotFoundException {
        foodItemDao.deleteFoodItem(id);
    }

    @Override
    public void deletePurchase(long id) throws PurchaseNotFoundException {
        purchaseDao.deletePurchase(id);
    }

    @Override
    public void deleteRestaurant(long id) throws RestaurantNotFoundException {
        restaurantDao.deleteRestaurant(id);
    }

    @Override
    public void deleteUser(long id) throws UserNotFoundException {
        userDao.deleteUser(id);
    }
}