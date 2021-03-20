/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Prashant Koshta
 */
public class FactoryProvider {
    
    private static SessionFactory factory;
    
    public static SessionFactory getFactory(){
        
        try{
            if(factory == null){
                factory = new Configuration().configure("hibernate/hibernate.cfg.xml").buildSessionFactory();
                System.out.println("factory" + factory);
            
            }
        }catch(Exception e){
    e.printStackTrace();
    }
        return factory;
}
    
}
