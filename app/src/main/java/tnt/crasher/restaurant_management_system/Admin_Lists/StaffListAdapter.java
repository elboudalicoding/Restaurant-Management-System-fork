package tnt.crasher.restaurant_management_system.Admin_Lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import tnt.crasher.restaurant_management_system.R;

public class StaffListAdapter extends ArrayAdapter<StaffList> {

    private int resourceLayout;
    private Context context;

    public StaffListAdapter(Context context, int resourceLayout, ArrayList<StaffList> items){
        super(context, resourceLayout, items);
        this.context = context;
        this.resourceLayout = resourceLayout;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(resourceLayout, null);
        }

        StaffList p = getItem(position);

        if(p != null){
            TextView staffname = (TextView)v.findViewById(R.id.label_staffname);
            TextView staffposition = (TextView)v.findViewById(R.id.lable_staffposition);

            if(staffname != null){
                staffname.setText(p.getLastname() + " " + p.getFirstname());
            }
            if(staffposition != null){
                staffposition.setText(p.getPosition());
            }

        }

        return v;

    }
}
