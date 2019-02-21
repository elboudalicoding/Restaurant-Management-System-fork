package tnt.crasher.restaurant_management_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import tnt.crasher.restaurant_management_system.Staff.MainStaff;
import tnt.crasher.restaurant_management_system.User.MenuDish;
import tnt.crasher.restaurant_management_system.User.VIP.MenuVIP;

public class MainActivity extends AppCompatActivity {
    private Button button_guest, button_vip, button_staff, button_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page_layout);

        button_guest = findViewById(R.id.button_guest);
        button_vip = findViewById(R.id.button_vip);
        button_staff = findViewById(R.id.button_staff);

        button_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuDish.class);
                startActivity(intent);
            }
        });

        button_staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainStaff.class);
                startActivity(intent);
            }
        });

        button_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuVIP.class);
                startActivity(intent);
            }
        });
    }
}
