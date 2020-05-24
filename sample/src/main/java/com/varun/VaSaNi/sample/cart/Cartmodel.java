package com.varun.VaSaNi.sample.cart;

public class Cartmodel {
    //String id;
    int image;
    String title;
    String currency;
    String price;
    String attribute;
    String quantity;
    String subTotal;


    public Cartmodel() {
    }


    public Cartmodel(String title, int image, String currency, String price, String attribute, String quantity, String subTotal) {
        //this.id = id;
        this.image = image;
        this.title = title;
        this.currency = currency;
        this.price = price;
        this.attribute = attribute;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }


    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getAttribute() {
        return attribute;
    }
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getQuantity() {
        return quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
