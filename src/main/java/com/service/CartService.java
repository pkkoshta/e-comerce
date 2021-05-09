package com.service;

import com.entity.CartItem;

import java.util.List;

public interface CartService {

    List <CartItem> getItems();

    CartItem addCart(CartItem cartItem);

}
