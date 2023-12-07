package com.app.springreact.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Meetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String address;

    private String image;

    @Column(length = 65535, columnDefinition="TEXT")
    private String description;
}
