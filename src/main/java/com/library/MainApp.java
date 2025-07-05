package main.java.com.library;

import main.java.com.library.controllers.LibraryController;
import main.java.com.library.dao.*;
import main.java.com.library.dao.impl.*;
import main.java.com.library.services.LibraryServices;
import main.java.com.library.services.LibraryServicesImpl;

public class MainApp {
    public static void main(String[] args) {
        CategoryDao categoryDao = new InMemoryCategoryDao();
        FoodItemDao foodItemDao = new InMemoryFoodItemDao();
        PurchaseDao purchaseDao = new InMemoryPurchaseDao();
        RestaurantDao restaurantDao = new InMemoryRestaurantDao();
        UserDao userDao = new InMemoryUserDao();

        LibraryServices libraryServices = new LibraryServicesImpl(userDao,restaurantDao,categoryDao,purchaseDao,foodItemDao);

        LibraryController controller = new LibraryController(libraryServices);

        controller.start();
    }
}
