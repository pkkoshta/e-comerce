package com.service;

import com.dao.CheckOutDao;
import com.dao.UserDao;
import com.entity.CheckOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckOutService implements  CheckOutServiceInter{
    @Autowired
    private CheckOutDao checkOutDao;
    @Autowired
    private UserDao userDao;

    public void saveCheckoutetails(CheckOut checkOut){

        checkOutDao.save(checkOut);

    }
}
