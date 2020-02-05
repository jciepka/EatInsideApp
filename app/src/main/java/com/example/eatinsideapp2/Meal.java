package com.example.eatinsideapp2;


public class Meal {
    private long mealId;
    private String name;
    private double price;
    private boolean isSelected;
    private String details;

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Meal(String name, float price, String details) {

        this.name = name;
        this.price = price;
        this.details = details;
    }



    public long getMealId() {
        return mealId;
    }

    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        this.isSelected = selected;
    }
}
