package com.service;

import com.dao.CartDao;
import com.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartDao cartDao;

    @Override
    public List <CartItem> getItems () {
        return cartDao.findAll();
    }

    @Override
    public CartItem addCart (CartItem cartItem) {
        return cartDao.save(cartItem);
    }
}
