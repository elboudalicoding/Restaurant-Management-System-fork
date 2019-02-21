package tnt.crasher.restaurant_management_system.User.VIP;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import tnt.crasher.restaurant_management_system.R;

public class MenuVIP extends AppCompatActivity {
    private ImageView button_points, button_membership, button_preferences, button_order;
    private TextView label_vipname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vip_homepage);

        Intent i = getIntent();

        String name = i.getStringExtra("VIP");

        button_points = findViewById(R.id.button_points);
        button_membership = findViewById(R.id.button_membership);
        button_order = findViewById(R.id.button_points);
        button_preferences = findViewById(R.id.button_preferences);

        label_vipname = findViewById(R.id.label_vipname);
        label_vipname.setText("WELCOME " + name);

        button_points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PointsVIP.class);
                startActivity(intent);
            }
        });

        button_membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MembershipVIP.class);
                startActivity(intent);
            }
        });
    }

}
