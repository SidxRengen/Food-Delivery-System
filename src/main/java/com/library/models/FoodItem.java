package main.java.com.library.models;

import main.java.com.library.utils.AddOnTypes;

import java.util.List;

public class FoodItem extends BaseEntry{
    private String name;
    private String description;
    private int price;
    private int stock;
    private List<AddOnTypes> addOns;
    private Category category;
    private Restaurant restaurant;

    public FoodItem(String name, String description, int price, int stock, List<AddOnTypes> addOns, Category category,Restaurant restaurant){
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.addOns = addOns;
        this.category = category;
        this.restaurant = restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<AddOnTypes> getAddOns() {
        return addOns;
    }

    public int getStock() {
        return stock;
    }

    public String getDescription() {
        return description;
    }

    public void setAddOns(List<AddOnTypes> addOns) {
        this.addOns = addOns;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString(){
        return "FoodItem{id= "+getId() +", name= "+name+", description= "+description+", price= "+price+", stock= "+stock+"}";
    }
}
