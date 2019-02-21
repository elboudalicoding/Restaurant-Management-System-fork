package tnt.crasher.restaurant_management_system.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import tnt.crasher.restaurant_management_system.R;

public class Checkout extends AppCompatActivity {
    private TextView appetizerLists, foodLists, beverageLists;
    private Button button_order, button_checkout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        appetizerLists = findViewById(R.id.appetizerLists);
        foodLists = findViewById(R.id.foodLists);
        beverageLists = findViewById(R.id.beverageLists);

        button_checkout = findViewById(R.id.button_checkout);
        button_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThankYou.class);
                startActivity(intent);
            }
        });

        button_order = findViewById(R.id.button_order);
        button_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuDish.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        HashMap<String, Integer> checkedAppetizer = (HashMap<String, Integer>) intent.getSerializableExtra("appetizer_lists");
        HashMap<String, Integer> checkedFood = (HashMap<String, Integer>) intent.getSerializableExtra("food_lists");
        HashMap<String, Integer> checkedBeverage = (HashMap<String, Integer>) intent.getSerializableExtra("beverage_lists");

        Log.d("SELECTED ITEM", String.valueOf(checkedFood));
        String final_appetizer = "";
        String final_food = "";
        String final_beverage = "";

        final_appetizer = loopItem(checkedAppetizer, final_appetizer);
        final_food = loopItem(checkedFood, final_food);
        final_beverage = loopItem(checkedBeverage, final_beverage);

        appetizerLists.setText(final_appetizer);
        foodLists.setText(final_food);
        beverageLists.setText(final_beverage);

    }

    public String loopItem(HashMap<String, Integer> list, String final_item){
        for (Map.Entry<String, Integer> entry: list.entrySet()) {
            final_item = final_item + entry.getKey() + " " + entry.getValue() + "x" + "\n";
        }
        return final_item;
    }
}
