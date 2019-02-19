package tnt.crasher.restaurant_management_system.User;

import android.os.Bundle;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import tnt.crasher.restaurant_management_system.R;

public class MenuDish extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private BottomAppBar bottomAppBar;

    List<Data> dataList, filteredDataList;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_dish);

        dataList = new ArrayList<>();
        dataList.add(new Data("Adobo","An oily chicken with soy sauce",R.drawable.p1,5,0));
        dataList.add(new Data("Fried Chicken","An oily and crispy chicken with golden looks",R.drawable.p2,4,0));
        dataList.add(new Data("Sinigang","A sour pork with soup and vegetables",R.drawable.p3,3,0));
        dataList.add(new Data("Letchon Paksiw","You can easily go to heaven when eating this...",R.drawable.p4,2,0));
        dataList.add(new Data("Pakbet","Many vegetables with chicharoon and bagoong",R.drawable.p2,1,0));
        dataList.add(new Data("Sisig","Chop chop pork with oily features",R.drawable.p3,2,0));
        dataList.add(new Data("Bicol Express","You will be a dragon after eating this...",R.drawable.p5,4, 0));


        recyclerView= findViewById(R.id.recyclerViewMain);
        layoutManager =new LinearLayoutManager(MenuDish.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter =new RecyclerViewAdapter(dataList);
        recyclerView.setAdapter(adapter);
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

        filteredDataList = filter(dataList, newText);
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
