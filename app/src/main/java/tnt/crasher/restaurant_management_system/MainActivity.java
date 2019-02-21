package tnt.crasher.restaurant_management_system;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import tnt.crasher.restaurant_management_system.Admin.AdminMenu;
import tnt.crasher.restaurant_management_system.User.MenuDish;

public class MainActivity extends AppCompatActivity {
    private Button button_user;
    private RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(MainActivity.this, AdminMenu.class);
        startActivity(i);

        button_user = findViewById(R.id.button_user);
        ratingBar = findViewById(R.id.ratingBar2);

        ratingBar.setFocusable(true);

        button_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuDish.class);
                startActivity(intent);
            }
        });

        View.OnTouchListener listenerRatingBar = new View.OnTouchListener() {
            float xDown;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // save down X coordinate
                    xDown = event.getX();
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    // if user moves do not move the finger, update RatingBar value
                    if (Math.abs(xDown - event.getX()) < 5) {
                        return false;
                    }
                }
                return true;
            }
        };

        ratingBar.setOnTouchListener(listenerRatingBar);
    }
}
