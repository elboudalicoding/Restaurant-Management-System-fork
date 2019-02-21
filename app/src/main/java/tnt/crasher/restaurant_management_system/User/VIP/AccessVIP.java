package tnt.crasher.restaurant_management_system.User.VIP;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
                Log.d("FUCK", selectedId + "");
                switch(selectedId){
                    case R.id.name_sherwyne:
                        name = "Sherwyne";
                        break;
                    case R.id.name_jastoni:
                        name = "Jastoni";
                        break;
                    case R.id.name_keiji:
                        name = "Keiji";
                        break;
                    case R.id.name_joshua:
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
