package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;
    private String productName;
    private String pPhoto;
    private int price;
    private int discount;
    private int quatity;

    public CartItem () {
    }

    public CartItem (String productName, String pPhoto, int price, int discount, int quatity) {
        this.productName = productName;
        this.pPhoto = pPhoto;
        this.price = price;
        this.discount = discount;
        this.quatity = quatity;
    }

    public Integer getCartId () {
        return cartId;
    }

    public void setCartId (Integer cartId) {
        this.cartId = cartId;
    }

    public String getProductName () {
        return productName;
    }

    public void setProductName (String productName) {
        this.productName = productName;
    }

    public String getpPhoto () {
        return pPhoto;
    }

    public void setpPhoto (String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public int getPrice () {
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }

    public int getDiscount () {
        return discount;
    }

    public void setDiscount (int discount) {
        this.discount = discount;
    }

    public int getQuatity () {
        return quatity;
    }

    public void setQuatity (int quatity) {
        this.quatity = quatity;
    }

    @Override
    public String toString () {
        return "CartItem{" +
                "cartId=" + cartId +
                ", productName='" + productName + '\'' +
                ", pPhoto='" + pPhoto + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", quatity=" + quatity +
                '}';
    }
}
