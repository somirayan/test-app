package com.app.springreact.controller;

import com.app.springreact.model.request.CartRequest;
import com.app.springreact.model.response.CartResponse;
import com.app.springreact.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping
    public CartResponse updateCart(CartRequest request) {
        System.out.println("request : " + request);
        return cartService.updateCart(request);
    };
}
