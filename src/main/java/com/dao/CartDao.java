package com.dao;

import com.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartDao extends JpaRepository<CartItem, Integer> {
}
