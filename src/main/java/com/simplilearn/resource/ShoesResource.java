package com.simplilearn.resource;

import com.simplilearn.Dto.ShoeDto;
import com.simplilearn.model.Category;
import com.simplilearn.model.Shoes;
import com.simplilearn.service.CategoryService;
import com.simplilearn.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("")

public class ShoesResource {

    @Autowired
    ShoesService shoesService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/shoes")
    public String shoesPage(Model model) {
        model.addAttribute("shoes", shoesService.getAllShoes());
        model.addAttribute("categories", categoryService.getAllCategories());

        return "shoes";
    }

    @PostMapping("/deleteShoe/{id}")
    public String deleteShoe(@PathVariable("id") Long id) {
        shoesService.deleteShoeById(id);
        return "redirect:/shoes";
    }

    @GetMapping("/shoes/add")
    public String showAddNewShoeForm(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "addNewShoe";
    }

    @PostMapping("/shoes/add")
    public String addShoe(@RequestBody ShoeDto shoeDto) {
        Shoes shoe = new Shoes();
        shoe.setName(shoeDto.getShoeName());
        shoe.setDescription(shoeDto.getDescription());
        shoe.setPrice(Double.parseDouble(shoeDto.getPrice()));

        Optional<Category> category = categoryService.getCatById(Integer.parseInt(shoeDto.getCategory()));
        if (category.isPresent()) {
            shoe.setCategory(category.get());
            shoesService.addShoe(shoe);
        }
        return "redirect:/shoes";
    }
}

