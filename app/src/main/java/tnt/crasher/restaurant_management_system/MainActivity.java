package tnt.crasher.restaurant_management_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import tnt.crasher.restaurant_management_system.User.MenuDish;

public class MainActivity extends AppCompatActivity {
    private Button button_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_user = findViewById(R.id.button_user);

        button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuDish.class);
                startActivity(intent);
            }
        });
    }
}
