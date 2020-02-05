package com.example.eatinsideapp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;


public class Pop  extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popupwindow);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .3));


    }

    public void onClickLogConfirm(View v) {
        switch (MainActivity.USER) {
            case "Manager":
                startActivity(new Intent(Pop.this, ManagerActivity.class));
            case "Client":
                startActivity(new Intent(Pop.this, ClientActivity.class));
        }
//        if (MainActivity.USER == "Manager") {
//            startActivity(new Intent(Pop.this, ManagerActivity.class));
//        }
    }
}













