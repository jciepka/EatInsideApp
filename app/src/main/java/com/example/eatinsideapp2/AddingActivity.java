package com.example.eatinsideapp2;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;


public class AddingActivity extends AppCompatActivity {
    // private MealViewModel mealViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
    }

    public void onClickAdd(View v){
        Intent intent = new Intent();
        EditText editTextName = findViewById(R.id.nameText);
        String name = editTextName.getText().toString();
        EditText editTextCost = findViewById(R.id.priceText);
        int price = Integer.parseInt(editTextCost.getText().toString());
        EditText editTextDeatils = findViewById(R.id.detailsText);
        String details = editTextDeatils.getText().toString();
        Meal newMeal = new Meal(name,price,details);
        // final String meal_id = UUID.randomUUID();


        //MealsDB db = Room.databaseBuilder(getApplicationContext(),
        //MealsDB.class, "tasks-db").allowMainThreadQueries().build();
        // MenuAdapter.add(newMeal);
        // mealViewModel.insert(newMeal);
        // newMeal.setMealId(meal_id);
    }
}