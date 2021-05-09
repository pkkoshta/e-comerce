package com.service;

import com.entity.Product;
import com.entity.User;

import java.util.List;
import java.util.Optional;

public interface Userservice {


    public User getUserByEmail(String email, String pass);

    public User saveUser(User user);

    public User adminLog(String email, String password);
}
