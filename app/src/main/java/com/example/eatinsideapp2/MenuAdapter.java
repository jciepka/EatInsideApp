package com.example.eatinsideapp2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import java.util.List;

public class MenuAdapter  extends ArrayAdapter<Meal> {
    public List<Meal> menu;
    private Context context;
    private Order order = Order.getInstance();

    public MenuAdapter(@NonNull Context context, @NonNull List<Meal> meals) {
        super(context, 0, meals);
        this.context = context;
        this.menu = meals;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(context).inflate(R.layout.meal, parent, false);
        }
        if (menu.isEmpty()) {
//            // show popup with information about no available menu

//            LayoutInflater inflater = (LayoutInflater)
//                    getSystemService(LAYOUT_INFLATER_SERVICE);
//            View popupView = inflater.inflate(R.layout.popup_window, null);
//
//            // create the popup window
//            int width = LinearLayout.LayoutParams.WRAP_CONTENT;
//            int height = LinearLayout.LayoutParams.WRAP_CONTENT;
//            boolean focusable = true; // lets taps outside the popup also dismiss it
//            final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
//
//            // show the popup window
//            // which view you pass in doesn't matter, it is only used for the window tolken
//            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
//
//            // dismiss the popup window when touched
//            popupView.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    popupWindow.dismiss();
//                    return true;
//                }
//            });
        }
        final Meal meal = menu.get(position);
        if (meal!= null) {
            TextView mealTextView = v.findViewById(R.id.meal_name_tv);
            TextView priceTextView = v.findViewById(R.id.quantity_tv);
            TextView mealDescTextView = v.findViewById(R.id.meal_description_tv);
            Button addMeal = v.findViewById(R.id.add_meal_button);
            Button removeMeal = v.findViewById(R.id.remove_meal_button);


            if (priceTextView != null){
                priceTextView.setText(meal.getPrice()+ " zł");
            }
            if (mealTextView != null) {
                mealTextView.setText(meal.getName());
            }
            if (mealDescTextView != null) {
                mealDescTextView.setText(meal.getDetails());
            }
            if (addMeal != null) {
                addMeal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        order.addToOrder(meal);
                        TextView orderTextView = ((View)v.getParent().getParent().getParent()).findViewById(R.id.order_price_tv);
                        orderTextView.setText("Kwota zamówienia: " + order.getCost() + "zł");
                    }
                });
            }
            if (removeMeal != null) {
                removeMeal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        order.removeFromOrder(meal);
                        TextView orderTextView = ((View)v.getParent().getParent().getParent()).findViewById(R.id.order_price_tv);
                        orderTextView.setText("Kwota zamówienia: " + order.getCost() + "zł");
                    }
                });
            }
        }
        return v;
    }
}
