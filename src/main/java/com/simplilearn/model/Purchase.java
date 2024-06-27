package com.simplilearn.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "shoes_id")
    private Shoes shoes;

    @Column(name = "order_date")
    private LocalDate orderDate;

    private int userId;

    // Default constructor (required by JPA)
    public Purchase() {
    }

    // Constructor with shoes and orderDate
    public Purchase(Shoes shoes, LocalDate orderDate) {
        this.shoes = shoes;
        this.orderDate = orderDate;
    }

    // Getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
