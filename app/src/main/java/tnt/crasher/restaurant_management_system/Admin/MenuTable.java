package tnt.crasher.restaurant_management_system.Admin;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import tnt.crasher.restaurant_management_system.Admin_Lists.FoodList;
import tnt.crasher.restaurant_management_system.Admin_Lists.FoodListAdapter;
import tnt.crasher.restaurant_management_system.Database.DatabaseHelper;
import tnt.crasher.restaurant_management_system.R;

public class MenuTable extends AppCompatActivity {

    private ListView listView;
    private FoodListAdapter foodListAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_table);

        databaseHelper = new DatabaseHelper(this);

        listView = (ListView)findViewById(R.id.list_menus);
        ArrayList<FoodList> foodLists = new ArrayList<>();

        Cursor food = databaseHelper.getMenu();
        while(food.moveToNext()){
            foodLists.add(new FoodList(food.getInt(0), food.getString(1), food.getString(2), food.getDouble(3), food.getInt(5), food.getDouble(4)));
        }food.close();

        foodListAdapter = new FoodListAdapter(this, R.layout.food_table, foodLists);
        listView.setAdapter(foodListAdapter);

    }
}
