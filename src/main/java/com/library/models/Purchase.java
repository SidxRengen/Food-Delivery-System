package main.java.com.library.models;

import main.java.com.library.utils.Payment;

import java.util.Arrays;

public class Purchase extends BaseEntry {
    private User user;
    private Payment payment;
    private FoodItem[] foodItems ;
    private int price;

    public Purchase(User user, Payment payment, FoodItem[] foodItems, int price){
        this.foodItems = foodItems;
        this.price = price;
        this.user = user;
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public FoodItem[] getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(FoodItem[] foodItems) {
        this.foodItems = foodItems;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Category{user=" + user + ", payment=" + payment +", price="+price+", food items:"+ Arrays.toString(foodItems)+ "}";
    }
}
