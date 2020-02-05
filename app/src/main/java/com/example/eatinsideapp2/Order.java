package com.example.eatinsideapp2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Order {

    private ArrayList<Meal> mealsList = new ArrayList<>();
    private float cost = 0;
    private static Order instance = new Order();

    private Order() {
    }

    public static Order getInstance(){
        if(instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public ArrayList<Meal> getMealsList() {
        return mealsList;
    }

    public void setMealsList(ArrayList<Meal> mealsList) {
        this.mealsList = mealsList;
    }

    public float getCost() {
        return this.calculateCost(this.mealsList);
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void addToOrder(Meal meal) {
        this.mealsList.add(meal);
    }

    public void removeFromOrder(Meal meal) {
        if(this.mealsList.contains(meal)) {
            this.mealsList.remove(meal);
        }
    }

    public Order(ArrayList<Meal> mealsList) {
        this.mealsList = mealsList;
        this.cost = calculateCost(mealsList);
    }

    public float calculateCost(ArrayList<Meal> list){
        float sum = 0;
        if(list != null && !list.isEmpty()) {
            for(Meal meal : list) {
                if(meal != null) {
                    sum+=meal.getPrice();
                }
            }
        }
        return sum;
    }




}
