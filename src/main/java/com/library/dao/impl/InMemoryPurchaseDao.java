package main.java.com.library.dao.impl;

import main.java.com.library.dao.PurchaseDao;
import main.java.com.library.models.Purchase;
import main.java.com.library.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryPurchaseDao implements PurchaseDao {
    private final Map<Long, Purchase> purchases = new HashMap<>();
    private final AtomicLong ID = new AtomicLong(1);
    @Override
    public Purchase addPurchase(Purchase purchase) {
        long id = ID.getAndIncrement();
        purchase.setId(id);
        purchases.put(id, purchase);
        return purchase;
    }

    @Override
    public List<Purchase> getPurchasesFromUser(User user) {
        List<Purchase> list = new ArrayList<>();
        for(Purchase purchase:purchases.values()){
            if (purchase.getUser() == user){
                list.add(purchase);
            }
        }
        return list;
    }

    @Override
    public Purchase updatePurchase(Purchase purchase) {
        if (purchases.containsKey(purchase.getId())){
            purchases.put(purchase.getId(),purchase);
            return purchase;
        }
        return null;
    }

    @Override
    public Purchase getPurchasebyId(long id) {
        if (purchases.containsKey(id)){
            return purchases.get(id);
        }
        return null;
    }

    @Override
    public void deletePurchase(long id) {
        purchases.remove(id);
    }
}
