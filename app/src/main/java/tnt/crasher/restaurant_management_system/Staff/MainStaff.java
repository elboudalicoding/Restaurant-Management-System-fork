package tnt.crasher.restaurant_management_system.Staff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import tnt.crasher.restaurant_management_system.R;

public class MainStaff extends AppCompatActivity {
    private Button button_request, button_seats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_layout);

        button_request = findViewById(R.id.button_request);
        button_seats = findViewById(R.id.button_seats);

        button_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuStaff.class);
                startActivity(intent);
            }
        });
    }
}
