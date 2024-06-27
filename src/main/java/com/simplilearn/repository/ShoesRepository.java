package com.simplilearn.repository;

import com.simplilearn.model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ShoesRepository extends JpaRepository<Shoes, Long> {
    List<Shoes> findAllByCategoryId(int id);

}

