package tnt.crasher.restaurant_management_system.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tnt.crasher.restaurant_management_system.R;

public class AdminMenu extends AppCompatActivity {

    private Button button_menu, button_sales, button_orders, button_staff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        button_menu = (Button)findViewById(R.id.button_menu);
        button_sales = (Button)findViewById(R.id.button_sales);
        button_orders = (Button)findViewById(R.id.button_orders);
        button_staff = (Button)findViewById(R.id.button_staff);

        button_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuUpdate.class);
                startActivity(i);
            }
        });

        button_sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button_orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        button_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
