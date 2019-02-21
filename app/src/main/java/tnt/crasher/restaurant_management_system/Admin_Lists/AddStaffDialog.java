package tnt.crasher.restaurant_management_system.Admin_Lists;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import tnt.crasher.restaurant_management_system.Database.DatabaseHelper;
import tnt.crasher.restaurant_management_system.R;

public class AddStaffDialog extends Dialog implements android.view.View.OnClickListener {

    public Activity activity;
    public Dialog dialog;
    private Button addStaff, exit;

    private EditText firstname, lastname;
    private Spinner spinner_position;

    private DatabaseHelper databaseHelper;

    public AddStaffDialog(Activity activity){
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        databaseHelper = new DatabaseHelper(activity);

        setContentView(R.layout.add_staff_dialog);
        addStaff = (Button) findViewById(R.id.button_confirm);
        exit = (Button) findViewById(R.id.button_exit);
        addStaff.setOnClickListener(this);
        exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_confirm:

                firstname = (EditText)findViewById(R.id.field_firstname);
                lastname = (EditText)findViewById(R.id.field_lastname);

                String fn = firstname.getText().toString();
                String ln = firstname.getText().toString();

                spinner_position = (Spinner)findViewById(R.id.spinner_position);

                String pos = spinner_position.getSelectedItem().toString();

                if(!(fn.isEmpty() || ln.isEmpty())){
                    databaseHelper.addStaff(ln,fn,pos, "4:30 AM", "12:00 PM");
                    Toast.makeText(activity, "STAFF ADDED", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(activity, "STAFF ADDED", Toast.LENGTH_SHORT).show();
                }



                break;
            case R.id.button_exit:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }


}
