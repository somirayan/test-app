package com.app.springreact.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductRequest {

    private long id;

    private String title;

    private String price;

    private int quantity;

    @JsonProperty("total_price")
    private double totalPrice;

    private String description;
}
