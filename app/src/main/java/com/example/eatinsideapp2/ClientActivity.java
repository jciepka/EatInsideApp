package com.example.eatinsideapp2;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ClientActivity extends AppCompatActivity{
    private static final String MENU_FILE_NAME = "tasks.bin";
    private ArrayList<Meal> meals;
    private MenuAdapter menuAdapter;
    private ListView menuView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
    }
    public void onClickLogButton(View v){
        startActivity(new Intent(ClientActivity.this,Pop.class));
    }

    private void readTasksFromFile() {
        try {
            FileInputStream fis = openFileInput(MENU_FILE_NAME);
            ObjectInputStream is = new ObjectInputStream(fis);
            meals = (ArrayList<Meal>) is.readObject();
            is.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setupListViewListeners() {
        //menuView.setOnItemLongClickListener(

        // });

        menuView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                        Meal meal = meals.get(pos);
                        meal.setSelected(!meal.isSelected());
                        menuAdapter.notifyDataSetChanged();
                    }
                });
    }

    public void onClickOrder(View v){

    }
}




