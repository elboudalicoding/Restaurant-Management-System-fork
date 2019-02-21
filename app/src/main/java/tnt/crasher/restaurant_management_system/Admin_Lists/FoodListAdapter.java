package tnt.crasher.restaurant_management_system.Admin_Lists;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import tnt.crasher.restaurant_management_system.R;

public class FoodListAdapter extends ArrayAdapter<FoodList> {

    private int resourceLayout;
    private Context context;

    public FoodListAdapter(Context context, int resource, ArrayList<FoodList> items){
        super(context, resource, items);
        this.resourceLayout = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(context);
            v = vi.inflate(resourceLayout, null);
        }

        FoodList p = getItem(position);

        if(p != null){

            TextView id = (TextView)v.findViewById(R.id.list_id);
            TextView name = (TextView)v.findViewById(R.id.list_name);
            TextView desc = (TextView)v.findViewById(R.id.list_description);
            TextView price = (TextView)v.findViewById(R.id.list_price);
            TextView rating = (TextView)v.findViewById(R.id.list_rating);
            TextView type = (TextView)v.findViewById(R.id.list_type);

            if(id != null){
                id.setText(p.getId() + "");
            }
            if(name != null){
                name.setText(p.getName());
            }
            if(desc != null){
                desc.setText(p.getDescription());
            }
            if(price != null){
                price.setText(p.getPrice() + "");
            }
            if(rating != null){
                rating.setText(p.getRating() + "");
            }
            if(type != null){
                type.setText(p.getType() + "");
            }

        }

        return v;

    }
}
