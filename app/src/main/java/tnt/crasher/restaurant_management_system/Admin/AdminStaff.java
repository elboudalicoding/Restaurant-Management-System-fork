package tnt.crasher.restaurant_management_system.Admin;

import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import tnt.crasher.restaurant_management_system.Admin_Lists.AddStaffDialog;
import tnt.crasher.restaurant_management_system.Admin_Lists.StaffList;
import tnt.crasher.restaurant_management_system.Admin_Lists.StaffListAdapter;
import tnt.crasher.restaurant_management_system.Database.DatabaseHelper;
import tnt.crasher.restaurant_management_system.R;

public class AdminStaff extends AppCompatActivity {

    private FloatingActionButton button_addstaff;

    private ListView staffList;
    private StaffListAdapter staffListAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_staff);

        databaseHelper = new DatabaseHelper(getApplicationContext());

        staffList = (ListView)findViewById(R.id.listview_staffmembers);
        ArrayList<StaffList> staffLists = new ArrayList<>();

        button_addstaff = (FloatingActionButton)findViewById(R.id.button_addstaff);

        Cursor staff = databaseHelper.getStaff();
        while(staff.moveToNext()){
            staffLists.add(new StaffList(staff.getString(2), staff.getString(1), staff.getString(3), staff.getString(4), staff.getString(5)));
        }
        staff.close();

        staffListAdapter = new StaffListAdapter(this, R.layout.staff_list, staffLists);
        staffList.setAdapter(staffListAdapter);

        button_addstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddStaffDialog cdd = new AddStaffDialog(AdminStaff.this);
                cdd.show();
            }
        });


    }
}
