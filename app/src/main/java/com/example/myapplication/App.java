package com.example.myapplication;

import java.io.Serializable;

public class App implements Serializable {
    private String image , name , current_price , symbol;

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getCurrent_price() {
        return current_price;
    }

    public String getSymbol() {
        return symbol;
    }
}
