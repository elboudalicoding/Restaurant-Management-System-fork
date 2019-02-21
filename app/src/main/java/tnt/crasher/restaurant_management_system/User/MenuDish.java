package tnt.crasher.restaurant_management_system.User;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tnt.crasher.restaurant_management_system.Database.DatabaseHelper;
import tnt.crasher.restaurant_management_system.R;

public class MenuDish extends AppCompatActivity implements SearchView.OnQueryTextListener {

    List<Data> dataFood, dataBeverage, dataAppetizer, filteredDataList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter adapter;

    ArrayList<String> foodLists = new ArrayList<>();
    ArrayList<String> beverageLists = new ArrayList<>();
    ArrayList<String> appetizerLists = new ArrayList<>();

    int i = 0;
    ArrayList<String> category = new ArrayList<>(Arrays.asList("Appetizer", "Food", "Beverage"));
    String category_name = "Appetizer";

    Button button_proceed, button_skip;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_dish);

        databaseHelper = new DatabaseHelper(getApplicationContext());

        Cursor food = databaseHelper.getMenu(1);
        dataFood = new ArrayList<>();

        while(food.moveToNext()){
            dataFood.add(new Data(food.getString(1),food.getString(2),R.drawable.p1,Float.parseFloat(food.getDouble(4) + ""), "₱ " + food.getDouble(4)));
        }
        food.close();

//        dataFood.add(new Data("Adobo","An oily chicken with soy sauce",R.drawable.p1,5, "₱ 90.00"));
//        dataFood.add(new Data("Fried Chicken","An oily and crispy chicken with golden looks",R.drawable.p2,4,"₱ 40.00"));
//        dataFood.add(new Data("Sinigang","A sour pork with soup and vegetables",R.drawable.p3,3,"₱ 70.00"));
//        dataFood.add(new Data("Letchon Paksiw","You can easily go to heaven when eating this...",R.drawable.p4,2,"₱ 100.00"));
//        dataFood.add(new Data("Pakbet","Many vegetables with chicharoon and bagoong",R.drawable.p2,1,"₱ 40.00"));
//        dataFood.add(new Data("Sisig","Chop chop pork with oily features",R.drawable.p3,2,"₱ 30.00"));
//        dataFood.add(new Data("Bicol Express","You will be a dragon after eating this...",R.drawable.p5,4, "₱ 80.00"));

        Cursor bev = databaseHelper.getMenu(2);
        dataBeverage = new ArrayList<>();

        while(bev.moveToNext()){
            dataBeverage.add(new Data(bev.getString(1),bev.getString(2),R.drawable.p1,Float.parseFloat(bev.getDouble(4) + ""),"₱ " + bev.getDouble(4)));
        }
        bev.close();

//        dataBeverage.add(new Data("Coke","An oily chicken with soy sauce",R.drawable.p1,5,"₱ 20.00"));
//        dataBeverage.add(new Data("Ice Tea","An oily and crispy chicken with golden looks",R.drawable.p2,4,"₱ 25.00"));
//        dataBeverage.add(new Data("Milk Tea","A sour pork with soup and vegetables",R.drawable.p3,3,"₱ 50.00"));
//        dataBeverage.add(new Data("Lemonade","You can easily go to heaven when eating this...",R.drawable.p4,2,"₱ 20.00"));
//        dataBeverage.add(new Data("Beer","Many vegetables with chicharoon and bagoong",R.drawable.p2,1,"₱ 49.99"));
//        dataBeverage.add(new Data("Red Wine","Chop chop pork with oily features",R.drawable.p3,2,"₱ 39.99"));
//        dataBeverage.add(new Data("Chocolate Drink","You will be a dragon after eating this...",R.drawable.p5,4, "₱ 25.00"));

        Cursor appetize = databaseHelper.getMenu(0);
        dataAppetizer = new ArrayList<>();

        while(appetize.moveToNext()){
            dataAppetizer.add(new Data(appetize.getString(1),appetize.getString(2),R.drawable.p1,Float.parseFloat(appetize.getDouble(4) + ""),"₱ " + appetize.getDouble(4)));
        }
        appetize.close();

//        dataAppetizer.add(new Data("Snail","An oily chicken with soy sauce",R.drawable.p1,5,"₱ 50.00"));
//        dataAppetizer.add(new Data("Snake","An oily and crispy chicken with golden looks",R.drawable.p2,4,"₱ 40.00"));
//        dataAppetizer.add(new Data("Taho","A sour pork with soup and vegetables",R.drawable.p3,3,"₱ 10.00"));
//        dataAppetizer.add(new Data("Popcorn","You can easily go to heaven when eating this...",R.drawable.p4,2,"₱ 50.00"));
//        dataAppetizer.add(new Data("Donut","Many vegetables with chicharoon and bagoong",R.drawable.p2,1,"₱ 30.00"));
//        dataAppetizer.add(new Data("Pie","Chop chop pork with oily features",R.drawable.p3,2,"₱ 50.00"));
//        dataAppetizer.add(new Data("Salad","You will be a dragon after eating this...",R.drawable.p5,4, "₱ 20.00"));

        recyclerView= findViewById(R.id.recyclerViewMain);
        layoutManager =new LinearLayoutManager(MenuDish.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter =new RecyclerViewAdapter(dataAppetizer);
        adapter.setHasStableIds(true);
        adapter.setCategory(category_name);

        recyclerView.setItemViewCacheSize(200);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setAdapter(adapter);

        button_proceed = findViewById(R.id.button_proceed);

        button_proceed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (i < category.size()-1) {
                    Log.d("SELECT CATEGORY", category.get(i));
                    switch (category_name){
                        case "Appetizer":
                            appetizerLists.addAll(adapter.getAppetizer());
                            Log.d("SELECTA", String.valueOf(appetizerLists));
                            adapter =new RecyclerViewAdapter(dataFood);
                            category_name = "Food";
                            break;

                        case "Food":
                            foodLists.addAll(adapter.getFood());
                            Log.d("SELECTA", String.valueOf(foodLists));
                            adapter =new RecyclerViewAdapter(dataBeverage);
                            category_name = "Beverage";
                            break;
                        case "Beverage":
                            beverageLists.addAll(adapter.getBeverage());
                            Log.d("SELECTA", String.valueOf(beverageLists));
                            break;
                        default:
                            Log.d("SELECT ITEM", "NO MORE");
                    }

                    adapter.setCategory(category_name);
                    recyclerView.setAdapter(adapter);
                    i++;
                }

                else{
                    Log.d("SELECT", category.get(i));
                    switch (category_name){
                        case "Appetizer":
                            appetizerLists.addAll(adapter.getAppetizer());
                            Log.d("SELECTA", String.valueOf(appetizerLists));
                            break;
                        case "Food":
                            foodLists.addAll(adapter.getFood());
                            Log.d("SELECTA", String.valueOf(foodLists));
                            break;
                        case "Beverage":
                            beverageLists.addAll(adapter.getBeverage());
                            Log.d("SELECTA", String.valueOf(beverageLists));
                            break;
                        default:
                            Log.d("SELECT ITEM", "NO MORE");
                    }
                    Intent intent = new Intent(getApplicationContext(), Checkout.class);
                    intent.putStringArrayListExtra("food_lists", foodLists);
                    intent.putStringArrayListExtra("beverage_lists", beverageLists);
                    intent.putStringArrayListExtra("appetizer_lists", appetizerLists);

                    startActivity(intent);
                }
            }
        });





    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        switch (category_name){
            case "Food":
                filteredDataList = filter(dataFood, newText);
                break;
            case "Beverage":
                filteredDataList = filter(dataBeverage, newText);
                break;
            case "Appetizer":
                filteredDataList = filter(dataAppetizer, newText);
                break;
            default:
                break;
        }
        adapter.setFilter(filteredDataList);
        return true;
    }

    private List<Data> filter(List<Data> dataList, String newText) {
        newText=newText.toLowerCase();
        String text;
        filteredDataList=new ArrayList<>();
        for(Data dataFromDataList:dataList){
            text=dataFromDataList.title.toLowerCase();

            if(text.contains(newText)){
                filteredDataList.add(dataFromDataList);
            }
        }

        return filteredDataList;
    }
}
