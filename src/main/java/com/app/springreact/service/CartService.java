package com.app.springreact.service;

import com.app.springreact.model.request.CartRequest;
import com.app.springreact.model.response.CartResponse;

public interface CartService {

    CartResponse updateCart(CartRequest request);

}
