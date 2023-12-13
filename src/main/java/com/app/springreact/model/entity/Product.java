package com.app.springreact.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String price;

    private int quantity;

    private String description;

    private double totalPrice;

    @ManyToOne
    private Cart cart;
}
