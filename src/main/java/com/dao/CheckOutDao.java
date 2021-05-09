package com.dao;

import com.entity.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckOutDao extends JpaRepository<CheckOut, Integer> {
}
