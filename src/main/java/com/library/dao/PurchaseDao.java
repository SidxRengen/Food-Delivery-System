package main.java.com.library.dao;

import main.java.com.library.models.Purchase;
import main.java.com.library.models.User;

import java.util.List;

public interface PurchaseDao {
    Purchase addPurchase(Purchase purchase);
    Purchase updatePurchase(Purchase purchase);
    void deletePurchase(long id);
    Purchase getPurchasebyId(long id);
    List<Purchase> getPurchasesFromUser(User user);

}
