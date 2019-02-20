package tnt.crasher.restaurant_management_system.User.VIP;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import tnt.crasher.restaurant_management_system.R;

public class AccessVIP extends AppCompatActivity {
    ImageView finger_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finger_print_layout);

        finger_print = findViewById(R.id.image_fingerprint);
        finger_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuVIP.class);
                startActivity(intent);
            }
        });
    }
}
