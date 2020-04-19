package com.example.financeapp;

public class Stock {
    private String mName, mFullName, mPrice, mChange,mPercentChange;
    private int shares;

    public Stock(String mName, String mFullName, String mPrice, String mPercentChange, int shares){
        this.mName = mName;
        this.mFullName = mFullName;
        this.mPrice = mPrice;
        this.mPercentChange = mPercentChange;
        this.shares = shares;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public void setFullName(String mFullName) {
        this.mFullName = mFullName;
    }

    public void setPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public void setChange(String mChange) {
        this.mChange = mChange;
    }

    public void setPercentChange(String mPercentChange) {
        this.mPercentChange = mPercentChange;
    }

    public String getName() {
        return mName;
    }

    public String getFullName() {
        return mFullName;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getChange() {
        return mChange;
    }

    public String getPercentChange() {
        return mPercentChange;
    }
    public void setShares(int shares){ this.shares =shares;}
    public int getShares() {return shares;}
}
