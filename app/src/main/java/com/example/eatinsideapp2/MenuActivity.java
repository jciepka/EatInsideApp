package com.example.eatinsideapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuActivity extends AppCompatActivity {

    private ListView listView;
    private MenuAdapter menuAdapter;
    private float summaryPrice = 0;
    public Order order = Order.getInstance();
    TextView orderTextView;

//    Button addButton  = findViewById(R.id.add_meal_button);
//    Button removeButton = findViewById(R.id.remove_meal_button);
//    TextView mealTextView = findViewById(R.id.meal_name_tv);
//    TextView quantityTextView = findViewById(R.id.quantity_tv);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        orderTextView = (TextView) findViewById(R.id.order_price_tv);
        orderTextView.setText("Kwota zamówienia: 0 zł");



        listView = (ListView) findViewById(R.id.menu_list);

        ArrayList<Meal> mealsList = new ArrayList<>();
        mealsList.add(new Meal("PROMOCJA!!!! ŁOSOŚ NORWESKI ZE SZPINAKIEM", 16.00f, "pieczony stek oryginalnego łososia norweskiego z liśćmi szpinaku z dodatkiem suszonych pomidorów"));
        mealsList.add(new Meal("PIZZA BROCCOLI",20.00f,"składniiki sos, ser, pieczarki, kukurydza, papryka, brokuły, oregano"));
        mealsList.add(new Meal("PIEROGI ZE SZPINAKIEM I SEREM FETA",14.00f,"Lepione na miejscu, z dodatkiem masła lub cebulki do wyboru, przywołają smak niedzielnych obiadów u babci. Porcja 12 sztuk. Potrawa wegetarianska. Zawiera gluten."));
        mealsList.add(new Meal("PIZZA VEGETARIANA",22.00f,"składniki: sos, ser, cebula, pomidor, ogórek, kukurydza, papryka, oregano"));
        mealsList.add(new Meal("NALEŚNIKI Z SEREM",10.50f,"Domowe ciasto naleśnikowe, przełożone swojskim twarogiem z dodatkiem wanilii. Opiekane na maśle, podawane z bitą śmietaną, cukrem pudrem i miętą."));
        mealsList.add(new Meal("TAGLIATELLE Z BROKUŁAMI",25.00f,"makaron tagliatelle z brokułami, kurczakiem, pomidorami oraz dodatkiem cebulki, polane sosem śmietanowym i posypane parmezanem"));
        mealsList.add(new Meal("SPAGHETTI BOLOGNESE",22.00f,"Włoski makaron z dodatkiem sosu ze świeżych pomidorów, mielonego mięsa wieprzowego oraz bukietem świeżych ziół."));

        menuAdapter = new MenuAdapter(this, mealsList);
        listView.setAdapter(menuAdapter);


    }

    public void onAddButtonClicked(View v) {
        orderTextView.setText(": " + order.getCost() + "zł");
    }

    public void onRemoveButtonClicked(View v) {
        orderTextView.setText("Kwota zamówienia: " + order.getCost() + "zł");
    }
}
