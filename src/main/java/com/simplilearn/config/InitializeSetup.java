package com.simplilearn.config;

import com.simplilearn.Dto.SignUpDto;
import com.simplilearn.enums.UserRole;
import com.simplilearn.model.Category;
import com.simplilearn.model.Shoes;
import com.simplilearn.model.User;
import com.simplilearn.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.simplilearn.service.CategoryService;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.simplilearn.service.ShoesService;

@Component
public class InitializeSetup implements CommandLineRunner{

    @Autowired
    private ShoesService shoesService;

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {

        Category sportCategory = new Category("Sport Shoes");
        Category casualCategory = new Category("Casual Shoes");
        Category formalCategory = new Category("Formal Shoes");
        Category outdoorCategory = new Category("Outdoor Shoes");

        categoryService.addCategory(sportCategory);
        categoryService.addCategory(casualCategory);
        categoryService.addCategory(formalCategory);
        categoryService.addCategory(outdoorCategory);

        Shoes runningShoes = new Shoes("Running Shoes", sportCategory, 89.99, "Lightweight running shoes for enhanced performance.");
        Shoes leatherLoafers = new Shoes("Leather Loafers", casualCategory, 129.99, "Classic leather loafers for everyday wear.");
        Shoes highHeels = new Shoes("High Heels", formalCategory, 149.99, "Elegant high heels for formal occasions.");
        Shoes hikingBoots = new Shoes("Hiking Boots", outdoorCategory, 179.99, "Durable hiking boots for outdoor adventures.");
        Shoes sandals = new Shoes("Sandals", casualCategory, 59.99, "Comfortable sandals for casual wear.");
        Shoes dressShoes = new Shoes("Dress Shoes", formalCategory, 99.99, "Stylish dress shoes for business attire.");
        Shoes sneakers = new Shoes("Sneakers", sportCategory, 79.99, "Versatile sneakers for various sports activities.");
        Shoes flats = new Shoes("Flats", casualCategory, 69.99, "Chic flats for everyday comfort.");

        shoesService.addShoe(runningShoes);
        shoesService.addShoe(leatherLoafers);
        shoesService.addShoe(highHeels);
        shoesService.addShoe(hikingBoots);
        shoesService.addShoe(sandals);
        shoesService.addShoe(dressShoes);
        shoesService.addShoe(sneakers);
        shoesService.addShoe(flats);

        SignUpDto user = new SignUpDto("admin", "admin", UserRole.ADMIN);
        authService.signUp(user);
  }

}