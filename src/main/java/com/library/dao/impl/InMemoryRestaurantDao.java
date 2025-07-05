package main.java.com.library.dao.impl;

import main.java.com.library.dao.RestaurantDao;
import main.java.com.library.models.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryRestaurantDao implements RestaurantDao {
    private final Map<Long, Restaurant> restaurants = new HashMap<>();
    private final AtomicLong ID = new AtomicLong(1);

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        long id = ID.getAndIncrement();
        restaurant.setId(id);
        restaurants.put(id, restaurant);
        return restaurant;
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        if (restaurants.containsKey(restaurant.getId())){
            restaurants.put(restaurant.getId(),restaurant);
            return restaurant;
        }
        return null;
    }

    @Override
    public Restaurant getRestaurantbyId(long id) {
        return restaurants.get(id);
    }

    @Override
    public void deleteRestaurant(long id) {
        restaurants.remove(id);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return new ArrayList<>(restaurants.values());
    }
}
