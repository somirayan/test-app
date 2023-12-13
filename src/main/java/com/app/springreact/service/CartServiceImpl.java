package com.app.springreact.service;

import com.app.springreact.model.entity.Cart;
import com.app.springreact.model.entity.Product;
import com.app.springreact.model.request.CartRequest;
import com.app.springreact.model.request.ProductRequest;
import com.app.springreact.model.response.CartResponse;
import com.app.springreact.repository.CartRepository;
import com.app.springreact.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public CartResponse updateCart(CartRequest request) {

        Optional<Cart> getCart = cartRepository.findById(request.getId());

        getCart.ifPresent(cart -> cart.getItems().forEach(p -> {

            getCart.get().setTotalQuantity(request.getTotalQuantity());

            request.getItems().forEach(item -> {
                Optional<Product> getProduct = productRepository.findById(item.getId());

                if (getProduct.isPresent()) {
                    getProduct.get().setQuantity(item.getQuantity());
                    getProduct.get().setTotalPrice(item.getTotalPrice());

                    productRepository.save(getProduct.get());
                }
                
                if (getProduct.isEmpty()) {
                    addProduct(getCart.get(), item);
                }
            });

            CartResponse response = new CartResponse();

            //response.setTotalQuantity();
            
            
            
        }));
            
        
        if (getCart.isEmpty()) {
            Cart cart = new Cart();
            
            cart.setTotalQuantity(request.getTotalQuantity());

            cart.setItems(new ArrayList<>());
            
//            request.getItems().forEach(item -> {
//                cart.getItems().add(addProduct(cart,);)
//            });
        }
        
        

        return null;
    }

    private void addProduct(Cart cart, ProductRequest p) {
        Product product = new Product();
        product.setTitle(p.getTitle());
        product.setPrice(p.getPrice());
        product.setDescription(p.getDescription());
        product.setQuantity(p.getQuantity());
        product.setTotalPrice(p.getTotalPrice());
        product.setCart(cart);

        productRepository.save(product);
    }
}
