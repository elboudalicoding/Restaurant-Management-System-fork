package tnt.crasher.restaurant_management_system.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tnt.crasher.restaurant_management_system.R;

public class AdminLogin extends AppCompatActivity {

    private EditText username, password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        username = (EditText)findViewById(R.id.field_username);
        password = (EditText)findViewById(R.id.field_password);

        login = (Button)findViewById(R.id.button_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin")){
                    if(password.getText().toString().equals("admin")){
                        Intent i = new Intent(getApplicationContext(), AdminMenu.class);
                        startActivity(i);
                    }
                    else{
                        toastMessage("Try Again.");
                    }
                }
                else{
                    toastMessage("Try Again.");
                }
            }
        });

    }

    private void toastMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
