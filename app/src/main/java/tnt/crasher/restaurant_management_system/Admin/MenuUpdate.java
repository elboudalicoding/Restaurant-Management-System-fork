package tnt.crasher.restaurant_management_system.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import tnt.crasher.restaurant_management_system.Database.DatabaseHelper;
import tnt.crasher.restaurant_management_system.R;

public class MenuUpdate extends AppCompatActivity {

    private EditText field_name, field_description, field_price;
    private Spinner spinner_type;
    private Button add_menu;

    private String menu_name, menu_description, menu_price;
    private int menu_type;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_update);

        databaseHelper = new DatabaseHelper(getApplicationContext());

        field_name = (EditText)findViewById(R.id.field_menuname);
        field_description = (EditText)findViewById(R.id.field_description);
        field_price = (EditText)findViewById(R.id.field_price);

        spinner_type = (Spinner)findViewById(R.id.spinner_type);

        add_menu = (Button)findViewById(R.id.button_addmenu);

        add_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu_name = field_name.getText().toString();
                menu_description = field_name.getText().toString();
                menu_price = field_price.getText().toString();
                menu_type = spinner_type.getSelectedItemPosition();

                if(menu_name.isEmpty() ||
                menu_description.isEmpty() ||
                menu_price.isEmpty()){
                    toastMessage("You cannot leave those blank!");
                }
                else{
                    if(databaseHelper.addMenu(menu_name, menu_description, 0.0, Double.parseDouble(menu_price) ,menu_type)){
                        toastMessage("Successfully added");
                    }
                }

            }
        });

    }

    private void toastMessage(String message){
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
