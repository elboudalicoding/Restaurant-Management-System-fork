package tnt.crasher.restaurant_management_system.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import tnt.crasher.restaurant_management_system.R;

public class Checkout extends AppCompatActivity {
    private TextView appetizerLists, foodLists, beverageLists;
    private Button button_order;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        appetizerLists = findViewById(R.id.appetizerLists);
        foodLists = findViewById(R.id.foodLists);
        beverageLists = findViewById(R.id.beverageLists);

        button_order = findViewById(R.id.button_order);
        button_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThankYou.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        ArrayList<String> checkedAppetizer = intent.getStringArrayListExtra("appetizer_lists");
        ArrayList<String> checkedFood = intent.getStringArrayListExtra("food_lists");
        ArrayList<String> checkedBeverage = intent.getStringArrayListExtra("beverage_lists");

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

    public String loopItem(ArrayList list, String final_item){
        for (Object item : list) {
            final_item = final_item + item + "\n";
        }
        return final_item;
    }
}
