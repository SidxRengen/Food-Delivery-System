package main.java.com.library.dao;

import main.java.com.library.models.Restaurant;

import java.util.List;

public interface RestaurantDao {
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Restaurant restaurant);
    void deleteRestaurant(long id);
    Restaurant getRestaurantbyId(long id);
    List<Restaurant> getAllRestaurant();
}
