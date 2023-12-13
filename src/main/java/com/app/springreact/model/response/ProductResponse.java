package com.app.springreact.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductResponse {

    private long id;

    private String title;

    private String price;

    private int quantity;

    @JsonProperty("total_price")
    private double totalPrice;

    private String description;
}
