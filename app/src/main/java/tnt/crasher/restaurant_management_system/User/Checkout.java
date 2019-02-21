package tnt.crasher.restaurant_management_system.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import tnt.crasher.restaurant_management_system.R;

public class Checkout extends AppCompatActivity {
    private TextView foodLists;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        foodLists = findViewById(R.id.foodLists);

        Intent intent = getIntent();
        ArrayList<String> checkedFood = intent.getStringArrayListExtra("food_lists");
        Log.d("SELECTED ITEM", String.valueOf(checkedFood));
        String final_food = "";

        for (String food : checkedFood) {
            final_food = final_food + food + "\n";
        }
        foodLists.setText(final_food);
    }
}
