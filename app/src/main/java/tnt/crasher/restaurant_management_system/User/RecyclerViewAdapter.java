package tnt.crasher.restaurant_management_system.User;

import android.media.Image;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tnt.crasher.restaurant_management_system.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Data> dataList;

    private ArrayList<String> checkedFood = new ArrayList<>();
    private ArrayList<String> checkedBeverage = new ArrayList<>();
    private ArrayList<String> checkedAppetizer = new ArrayList<>();

    String category = "";


    RecyclerViewAdapter(List<Data> list) {
        this.dataList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview1, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder(view);

        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((ImageViewHolder) holder).imageView.setImageResource(dataList.get(position).photo);
        ((ImageViewHolder) holder).title.setText(dataList.get(position).title);
        ((ImageViewHolder) holder).about.setText(dataList.get(position).about);
        ((ImageViewHolder) holder).ratingBar.setRating(dataList.get(position).rating);
        ((ImageViewHolder) holder).price.setText(dataList.get(position).price);

//        ((ImageViewHolder) holder).ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                ratingBar.setRating(ratingBar.getRating());
//            }
//        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((ImageViewHolder) holder).checkBox.isChecked()){

                    ((ImageViewHolder) holder).checkBox.setChecked(false);
                    switch (category){
                        case "Food":
                            checkedFood.remove(((ImageViewHolder) holder).title.getText().toString());
                            break;
                        case "Beverage":
                            checkedBeverage.remove(((ImageViewHolder) holder).title.getText().toString());
                            break;
                        case "Appetizer":
                            checkedAppetizer.remove(((ImageViewHolder) holder).title.getText().toString());
                            break;
                        default:
                            Log.d("SELECT ITEM", "NO MORE");
                    }

                }

                else{

                    ((ImageViewHolder) holder).checkBox.setChecked(true);
                    switch (category){
                        case "Food":
                            checkedFood.add(((ImageViewHolder) holder).title.getText().toString());
                            break;
                        case "Beverage":
                            checkedBeverage.add(((ImageViewHolder) holder).title.getText().toString());
                            break;
                        case "Appetizer":
                            checkedAppetizer.add(((ImageViewHolder) holder).title.getText().toString());
                            break;
                        default:
                            Log.d("SELECT ITEM", "NO MORE");
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public ArrayList<String> getFood(){
        return checkedFood;
    }

    public ArrayList<String> getBeverage(){
        return checkedBeverage;
    }

    public ArrayList<String> getAppetizer(){
        return checkedAppetizer;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title, about, price;
        CardView cardView;
        RatingBar ratingBar;
        CheckBox checkBox;

        public ImageViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview1);
            imageView = itemView.findViewById(R.id.photo);
            title = itemView.findViewById(R.id.title);
            about = itemView.findViewById(R.id.about);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            price = itemView.findViewById(R.id.price);
            checkBox = itemView.findViewById(R.id.checkbox);

            ratingBar.setOnTouchListener(new View.OnTouchListener() {
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
            });
        }
    }

    public void setFilter(List<Data> FilteredDataList) {
        dataList = FilteredDataList;
        notifyDataSetChanged();
    }
}

