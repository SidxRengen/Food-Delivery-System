package main.java.com.library.controllers;

import main.java.com.library.exceptions.UserNotFoundException;
import main.java.com.library.models.*;
import main.java.com.library.services.LibraryServices;
import main.java.com.library.utils.AddOnTypes;
import main.java.com.library.utils.Payment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryController {
    private final LibraryServices libraryServices;
    private final Scanner scanner;

    public LibraryController(LibraryServices libraryServices) {
        this.libraryServices = libraryServices;
        this.scanner = new Scanner(System.in);
    }
    public void start(){
        System.out.println("=== Food Delivery System ===");
        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> manageUsers();
                case 2 -> manageFoodItems();
                case 3 -> managePurchases();
                case 4 -> manageRestaurant();
                case 5 -> manageCategories();
                case 0 -> {
                    System.out.println("Exiting system...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public void printMainMenu(){
        System.out.println("\nMain Menu:");
        System.out.println("1. User Management");
        System.out.println("2. Food Item Management");
        System.out.println("3. Purchase Management");
        System.out.println("4. Restaurant Management");
        System.out.println("5. Category Management");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void manageUsers() {
        boolean back = false;
        while (!back) {
            System.out.println("\nUser Management:");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Remove User");
            System.out.println("4. Search User");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addUser();
//                case 2 -> updateUser();
                case 3 -> removeUser();
                case 4 -> searchUsers();
                case 0 -> back = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public void searchUsers(){
        System.out.print("\nEnter User ID: ");
        long userId = scanner.nextLong();

        try {
            User user = libraryServices.getUserbyId(userId);
            System.out.println("\nUser Details:");
            System.out.println(user);
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void addUser(){
        System.out.println("\nAdd New User:");
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("address:");
        String address = scanner.nextLine();
        System.out.println("email:");
        String email = scanner.nextLine();
        System.out.println("Phone Number:");
        String phoneNumber = scanner.nextLine();

        User user = new User(name,address,email,phoneNumber);
        libraryServices.addUser(user);
        System.out.println("User added successfully!");
    }

    public void removeUser(){
        System.out.print("\nEnter User ID to remove: ");
        long bookId = scanner.nextLong();
        scanner.nextLine();

        try {
            libraryServices.deleteUser(bookId);
            System.out.println("User removed successfully!");
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void manageFoodItems(){
        boolean back = false;
        while (!back) {
            System.out.println("\nFood Item Management:");
            System.out.println("1. Add Food Item");
            System.out.println("2. Update Food Item");
            System.out.println("3. Remove Food Item");
            System.out.println("4. Search Food Item");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addFoodItem();
//                case 2 -> updateUser();
                case 3 -> removeFoodItem();
//                case 4 -> searchUsers();
                case 0 -> back = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public void removeFoodItem(){
        System.out.print("\nEnter Food Item ID to remove: ");
        long bookId = scanner.nextLong();
        scanner.nextLine();

        try {
            libraryServices.deleteFoodItem(bookId);
            System.out.println("Food Item removed successfully!");
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void addFoodItem() {
        System.out.println("\n--- Add New Food Item ---");

        System.out.print("Enter food name: ");
        String name = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Enter price: ");
        int price = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nSelect a Restaurant:");
        showAllRestaurant();
        List<Restaurant> restaurants = libraryServices.getAllRestaurant();
        int restaurantChoice = scanner.nextInt();
        scanner.nextLine();
        if (restaurantChoice < 1 || restaurantChoice > restaurants.size()) {
            System.out.println("Invalid restaurant choice.");
            return;
        }
        Restaurant restaurant = restaurants.get(restaurantChoice - 1);

        System.out.println("\nSelect a Category:");
        showAllCategories();
        List<Category> categories = libraryServices.getAllCategory();
        int categoryChoice = scanner.nextInt();
        scanner.nextLine();
        if (categoryChoice < 1 || categoryChoice > categories.size()) {
            System.out.println("Invalid category choice.");
            return;
        }
        Category category = categories.get(categoryChoice - 1);

        System.out.println("\nSelect AddOns (0 to finish):");
        List<AddOnTypes> allAddons = new ArrayList<>(List.of(AddOnTypes.values()));
        List<AddOnTypes> selectedAddons = new ArrayList<>();

        for (int i = 0; i < allAddons.size(); i++) {
            System.out.println((i + 1) + ". " + allAddons.get(i));
        }

        boolean adding = true;
        while (adding) {
            System.out.print("Your choice: ");
            int addonChoice = scanner.nextInt();
            scanner.nextLine();

            if (addonChoice == 0) {
                adding = false;
            } else if (addonChoice > 0 && addonChoice <= allAddons.size()) {
                AddOnTypes selected = allAddons.get(addonChoice - 1);
                if (!selectedAddons.contains(selected)) {
                    selectedAddons.add(selected);
                    System.out.println("AddOn added: " + selected);
                } else {
                    System.out.println("AddOn already selected.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }

        FoodItem foodItem = new FoodItem(name, description, price, stock, selectedAddons, category, restaurant);
        libraryServices.addFoodItem(foodItem);
        System.out.println("✅ Food Item added successfully!");
    }
    public void manageRestaurant(){
        boolean back = false;
        while (!back) {
            System.out.println("\nRestaurant Management:");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Update Restaurant");
            System.out.println("3. Remove Restaurant");
            System.out.println("4. Search Restaurant");
            System.out.println("5. All Restaurants");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addRestaurant();
//                case 2 -> updateUser();
                case 3 -> removeRestaurant();
//                case 4 -> searchUsers();
                case 5-> showAllRestaurant();
                case 0 -> back = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void removeRestaurant(){
        System.out.print("\nEnter Restaurant ID to remove: ");
        long bookId = scanner.nextLong();
        scanner.nextLine();

        try {
            libraryServices.deleteRestaurant(bookId);
            System.out.println("Restaurant removed successfully!");
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addRestaurant(){
        System.out.println("\nAdd New Restaurant:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Opening Time (HH:mm): ");
        String openTimeStr = scanner.nextLine();

        System.out.print("Closing Time (HH:mm): ");
        String closeTimeStr = scanner.nextLine();

        LocalDate today = LocalDate.now();
        LocalDateTime openTime = LocalDateTime.of(today, LocalTime.parse(openTimeStr));
        LocalDateTime closeTime = LocalDateTime.of(today, LocalTime.parse(closeTimeStr));

        Restaurant restaurant = new Restaurant(name, description, address, openTime, closeTime);
        libraryServices.addRestaurant(restaurant);

        System.out.println("Restaurant added successfully!");
    }

    public void showAllRestaurant(){
        List<Restaurant> list = libraryServices.getAllRestaurant();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i+1+". " +list.get(i).getName()+", ");
        }
    }

    public void manageCategories(){
        boolean back = false;
        while (!back) {
            System.out.println("\nCategory Management:");
            System.out.println("1. Add Category");
            System.out.println("2. Update Category");
            System.out.println("3. Remove Category");
            System.out.println("4. Search Category");
            System.out.println("5. All Category");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addCategory();
//                case 2 -> updateCategory();
                case 3 -> removeCategory();
//                case 4 -> searchCategory();
                case 5-> showAllCategories();
                case 0 -> back = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void removeCategory(){
        System.out.print("\nEnter Category ID to remove: ");
        long bookId = scanner.nextLong();
        scanner.nextLine();

        try {
            libraryServices.deleteCategory(bookId);
            System.out.println("Category removed successfully!");
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void addCategory(){
        System.out.println("\nAdd New Food Item:");
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("description:");
        String description = scanner.nextLine();
        Category category = new Category(name,description);
        libraryServices.addCategory(category);
        System.out.println("Category added successfully!");

    }

    public void showAllCategories(){
        List<Category> list = libraryServices.getAllCategory();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i+1+". " +list.get(i).getName()+", ");
        }
    }

    public void managePurchases(){
        boolean back = false;
        while (!back) {
            System.out.println("\nPurchase Management:");
            System.out.println("1. Add Purchase");
            System.out.println("2. Update Purchase");
            System.out.println("3. Remove Purchase");
            System.out.println("4. Search Purchase");
            System.out.println("5. Purchases from a User");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPurchase();
//                case 2 -> updatePurchase();
                case 3 -> removePurchase();
//                case 4 -> searchPurchase();
//                case 5-> showAllPurchases();
                case 6-> showPurchasesFromUser();
                case 0 -> back = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void addPurchase() {
        System.out.println("\nAdd Purchase Item:");
        System.out.print("Enter User ID: ");
        long userId = scanner.nextLong();
        scanner.nextLine();

        User user;
        try {
            user = libraryServices.getUserbyId(userId);
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        System.out.println("Select Payment option:");
        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < Payment.values().length; i++) {
            Payment type = Payment.values()[i];
            System.out.println((i + 1) + ". " + type);
            payments.add(type);
        }
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice < 1 || choice > payments.size()) {
            System.out.println("Invalid payment option.");
            return;
        }
        Payment payment = payments.get(choice - 1);

        System.out.println("Add Food Items:");
        List<FoodItem> foodItems = libraryServices.getAllItem();
        for (int j = 0; j < foodItems.size(); j++) {
            System.out.println((j + 1) + ". " + foodItems.get(j).getName() + " - ₹" + foodItems.get(j).getPrice());
        }

        System.out.println("0. Exit");
        List<FoodItem> selectedFoodItems = new ArrayList<>();
        int price = 0;

        while (true) {
            System.out.print("Enter your choice to add item (0 to finish): ");
            int itemChoice = scanner.nextInt();
            scanner.nextLine();
            if (itemChoice == 0) break;

            if (itemChoice < 1 || itemChoice > foodItems.size()) {
                System.out.println("Invalid choice, try again.");
            } else {
                FoodItem selected = foodItems.get(itemChoice - 1);
                selectedFoodItems.add(selected);
                price += selected.getPrice();
                System.out.println("Item added: " + selected.getName());
            }
        }

        if (selectedFoodItems.isEmpty()) {
            System.out.println("No food items selected. Purchase cancelled.");
            return;
        }

        Purchase purchase = new Purchase(user, payment, selectedFoodItems.toArray(new FoodItem[0]), price);
        libraryServices.addPurchase(purchase);
        System.out.println("Purchase added successfully!");
    }

    public void removePurchase(){
        System.out.print("\nEnter Purchase ID to remove: ");
        long bookId = scanner.nextLong();
        scanner.nextLine();

        try {
            libraryServices.deletePurchase(bookId);
            System.out.println("Purchase removed successfully!");
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void showPurchasesFromUser(){
        System.out.print("\nEnter User ID: ");
        long s = scanner.nextLong();
        User user = libraryServices.getUserbyId(s);
        List<Purchase> purchases =  libraryServices.getPurchasesFromUser(user);
        for (Purchase purchase : purchases) {
            System.out.println(purchase);
        }
    }
}
