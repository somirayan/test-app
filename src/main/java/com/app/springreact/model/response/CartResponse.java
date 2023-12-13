package com.app.springreact.model.response;

import com.app.springreact.model.request.ProductRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CartResponse {

    @JsonProperty("total_quantity")
    private int totalQuantity;

    List<ProductRequest> items;
}
