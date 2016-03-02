package com.charlesdrews.syncadapterslab;

/**
 * Created by Kyle McNee on 3/2/2016.
 */
public class StockQuote {
    String Name;
    double LastPrice;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getLastPrice() {
        return LastPrice;
    }

    public void setLastPrice(double lastPrice) {
        LastPrice = lastPrice;
    }
}
