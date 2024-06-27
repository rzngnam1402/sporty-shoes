package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.model.Shoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.simplilearn.repository.ShoesRepository;


@Service
public class ShoesService {

    @Autowired
    ShoesRepository shoesRepository;

    public List<Shoes> getAllShoes(){

        return shoesRepository.findAll();

    }

    public void addShoe(Shoes shoe) {

        shoesRepository.save(shoe);

    }

    public void removeShoeById(long id) {

        shoesRepository.deleteById(id);
    }

    public Optional<Shoes> getShoeById(long id){
        return shoesRepository.findById(id);
    }

    public List<Shoes> getAllShoesByCategoryId(int id){
        return shoesRepository.findAllByCategoryId(id);
    }

    public void deleteShoeById(Long id) {
        shoesRepository.deleteById(id);
    }
}

