package com.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String pName;
    @Column(length = 6000)
    private String pDesc;
    @Column(name = "pPhoto", length = 4000)
    private byte pPhoto[];
    private int pPrice;
    private int pDiscount;
    private int pQuatity;
    @ManyToOne( cascade = {CascadeType.MERGE})
    @JsonBackReference
    private Category category;


    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public Product() {


    }

    public int getPid () {
        return pid;
    }

    public void setPid (int pid) {
        this.pid = pid;
    }

    public String getpName () {
        return pName;
    }

    public void setpName (String pName) {
        this.pName = pName;
    }

    public String getpDesc () {
        return pDesc;
    }

    public void setpDesc (String pDesc) {
        this.pDesc = pDesc;
    }

    public byte[] getpPhoto () {
        return pPhoto;
    }

    public void setpPhoto (byte[] pPhoto) {
        this.pPhoto = pPhoto;
    }

    public int getpPrice () {
        return pPrice;
    }

    public void setpPrice (int pPrice) {
        this.pPrice = pPrice;
    }

    public int getpDiscount () {
        return pDiscount;
    }

    public void setpDiscount (int pDiscount) {
        this.pDiscount = pDiscount;
    }

    public int getpQuatity () {
        return pQuatity;
    }

    public void setpQuatity (int pQuatity) {
        this.pQuatity = pQuatity;
    }

    @Override
    public String toString () {
        return "Product{" +
                "pid=" + pid +
                ", pName='" + pName + '\'' +
                ", pDesc='" + pDesc + '\'' +
                ", pPhoto=" + Arrays.toString(pPhoto) +
                ", pPrice=" + pPrice +
                ", pDiscount=" + pDiscount +
                ", pQuatity=" + pQuatity +
                ", category=" + category +
                '}';
    }

    public Product (int pid, String pName, String pDesc, byte[] pPhoto, int pPrice, int pDiscount, int pQuatity, Category category) {
        this.pid = pid;
        this.pName = pName;
        this.pDesc = pDesc;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pDiscount = pDiscount;
        this.pQuatity = pQuatity;
        this.category = category;
    }
}
