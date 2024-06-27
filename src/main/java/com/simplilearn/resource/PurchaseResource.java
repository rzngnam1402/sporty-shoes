package com.simplilearn.resource;

import com.simplilearn.model.Purchase;
import com.simplilearn.model.Shoes;
import com.simplilearn.service.PurchaseService;
import com.simplilearn.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("purchase")
public class PurchaseResource {

    @Autowired
    ShoesService shoesService;

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    public PurchaseResource(ShoesService shoesService) {
        this.shoesService = shoesService;
    }

    @GetMapping("")
    public String showPurchaseList(Model model) {
        List<Purchase> purchases = purchaseService.getAllPurchase();
        model.addAttribute("purchasesList", purchases);
        return "purchase";
    }

    @PostMapping("/{id}")
    public String processPurchase(@PathVariable("id") Long id) {
        Shoes shoe = shoesService.getShoeById(id).orElseThrow(() -> new RuntimeException("Shoes not found"));

        LocalDate currentDate = LocalDate.now();
        Purchase newPurchase = new Purchase(shoe, currentDate);
        purchaseService.addPurchase(newPurchase);
        return "redirect:/purchase";
    }
}
