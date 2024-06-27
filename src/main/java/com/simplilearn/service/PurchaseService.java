package com.simplilearn.service;

import java.util.List;

import com.simplilearn.model.Purchase;
import com.simplilearn.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchase(){

        return purchaseRepository.findAll();

    }

    public void addPurchase(Purchase purchase) {

        purchaseRepository.save(purchase);

    }
    public void removePurchaseById(long id) {

        purchaseRepository.deleteById(id);
    }

}

