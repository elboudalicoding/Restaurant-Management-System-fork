package tnt.crasher.restaurant_management_system.User.VIP;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import tnt.crasher.restaurant_management_system.R;

public class AccessVIP extends AppCompatActivity {
    ImageView finger_print;
    RadioGroup names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finger_print_layout);

        finger_print = findViewById(R.id.image_fingerprint);

        names = (RadioGroup)findViewById(R.id.names);

        finger_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuVIP.class);
                String name = "";
                int selectedId = names.getCheckedRadioButtonId();
                switch(selectedId){
                    case 1:
                        name = "Sherwyne";
                        break;
                    case 2:
                        name = "Jastoni";
                        break;
                    case 3:
                        name = "Keiji";
                        break;
                    case 4:
                        name = "Joshua";
                        break;
                    default:
                        name = "VIP";
                }

                intent.putExtra("VIP", name);

                startActivity(intent);
            }
        });
    }
}
