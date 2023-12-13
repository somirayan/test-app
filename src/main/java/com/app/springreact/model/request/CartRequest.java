package com.app.springreact.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CartRequest {

    private long id;

    @JsonProperty("total_quantity")
    private int totalQuantity;

    List<ProductRequest> items;
}
