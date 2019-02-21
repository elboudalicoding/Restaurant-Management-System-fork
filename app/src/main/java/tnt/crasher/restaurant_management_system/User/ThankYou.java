package tnt.crasher.restaurant_management_system.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import tnt.crasher.restaurant_management_system.MainActivity;
import tnt.crasher.restaurant_management_system.R;

public class ThankYou extends AppCompatActivity {

    private Button button_thankyou;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou_layout);

        button_thankyou = findViewById(R.id.button_thankyou);
        button_thankyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
