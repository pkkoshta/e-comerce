package com.entity;

import org.json.JSONObject;

public class Payment {
    private int amount;
    private String status;
    private String currency;
    private String receipt;
    private int amount_due;

    public Payment () {
    }

    public Payment (int amount, String status, String currency, String receipt, int amount_due) {
        this.amount = amount;
        this.status = status;
        this.currency = currency;
        this.receipt = receipt;
        this.amount_due = amount_due;
    }

    public int getAmount (JSONObject jsonObject) {
        return amount;
    }

    public void setAmount (int amount) {
        this.amount = amount;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getCurrency () {
        return currency;
    }

    public void setCurrency (String currency) {
        this.currency = currency;
    }

    public String getReceipt () {
        return receipt;
    }

    public void setReceipt (String receipt) {
        this.receipt = receipt;
    }

    public int getAmount_due () {
        return amount_due;
    }

    public void setAmount_due (int amount_due) {
        this.amount_due = amount_due;
    }

    @Override
    public String toString () {
        return "Payment{" +
                "amount=" + amount +
                ", status='" + status + '\'' +
                ", currency='" + currency + '\'' +
                ", receipt='" + receipt + '\'' +
                ", amount_due=" + amount_due +
                '}';
    }


}
