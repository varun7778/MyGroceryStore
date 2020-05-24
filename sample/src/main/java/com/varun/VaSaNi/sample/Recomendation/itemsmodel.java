package com.varun.VaSaNi.sample.Recomendation;

public class itemsmodel {

    static int image;
    static String title;
    static String Quantity;
    static String price;




    public itemsmodel(int image, String title, String price, String quantity) {
        this.image = image;
        this.title = title;
        this.Quantity = quantity;
        this.price = price;

    }

    public static int getImage() {
        return image;
    }

    public static String getTitle() {
        return title;
    }

    public static String getQuantity() {
        return Quantity;
    }

    public static String getPrice() {
        return price;
    }

    }
