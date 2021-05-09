package com.service;

import com.dao.UserDao;
import com.entity.Product;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements Userservice{

    @Autowired private UserDao userDao;



    @Override
    public User getUserByEmail (String email, String pass) {
        return userDao.findByEmailAndPassword(email, pass);
    }

    @Override
    public User saveUser (User user) {
        if(user.getRole()==null){
            user.setRole("User");
        }
        return userDao.save(user);
    }

    @Override
    public User adminLog (String email, String password) {
        return userDao.findByEmailAndPassword(email, password);
    }

    // @Autowired private UserDao dao;


}
