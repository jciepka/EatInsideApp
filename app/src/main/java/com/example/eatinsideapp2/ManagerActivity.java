package com.example.eatinsideapp2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


import java.util.ArrayList;

public class ManagerActivity extends AppCompatActivity{
    private static final String MENU_FILE_NAME = "tasks.bin";
    private ArrayList<Meal> meals;
    private MenuAdapter menuAdapter;
    private ListView menuView;
    // private MealViewModel mealViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        // mealViewModel = ViewModelProviders.of(this).get(MealViewModel.class);

        //Intent intent = getIntent();
    }

    //    private void readTasksFromFile() {
//        try {
//            FileInputStream fis = openFileInput(MENU_FILE_NAME);
//            ObjectInputStream is = new ObjectInputStream(fis);
//            meals = (ArrayList<Meal>) is.readObject();
//            is.close();
//            fis.close();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
    public void onAddMeal(View v) {
        startActivity(new Intent(ManagerActivity.this,AddingActivity.class));
    }



}
