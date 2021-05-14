package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ckoId;
    private String firstName;
    private String lastName;
    private String address;
    private String country;
    private String state;
    private String zip;
    private double total;


    public CheckOut (int ckoId, String firstName, String lastName, String address, String country, String state, String zip, double total) {
        this.ckoId = ckoId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.state = state;
        this.zip = zip;
        this.total = total;
    }

    public CheckOut (String firstName, String lastName, String address, String country, String state, String zip, double total) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.country = country;
        this.state = state;
        this.zip = zip;
        this.total = total;
    }

    public CheckOut () {
    }

    public int getCkoId () {
        return ckoId;
    }

    public void setCkoId (int ckoId) {
        this.ckoId = ckoId;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getCountry () {
        return country;
    }

    public void setCountry (String country) {
        this.country = country;
    }

    public String getState () {
        return state;
    }

    public void setState (String state) {
        this.state = state;
    }

    public String getZip () {
        return zip;
    }

    public void setZip (String zip) {
        this.zip = zip;
    }

    public double getTotal () {
        return total;
    }

    public void setTotal (double total) {
        this.total = total;
    }

    @Override
    public String toString () {
        return "CheckOut{" +
                "ckoId=" + ckoId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", total=" + total +
                '}';
    }
}
