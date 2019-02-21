package tnt.crasher.restaurant_management_system.User;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import tnt.crasher.restaurant_management_system.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Data> dataList;

    private HashMap<String, Integer> checkedFood = new HashMap<>();
    private HashMap<String, Integer> checkedBeverage = new HashMap<>();
    private HashMap<String, Integer> checkedAppetizer = new HashMap<>();
    int food,beverage,appetizer;

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
                            food = 0;
                            ((ImageViewHolder) holder).quantity.setText(String.valueOf(food) + "x");
                            ((ImageViewHolder) holder).button_quantity.setVisibility(View.INVISIBLE);
                            checkedFood.remove(((ImageViewHolder) holder).title.getText().toString());

                            break;
                        case "Beverage":
                            beverage = 0;
                            ((ImageViewHolder) holder).quantity.setText(String.valueOf(beverage) + "x");
                            ((ImageViewHolder) holder).button_quantity.setVisibility(View.INVISIBLE);
                            checkedBeverage.remove(((ImageViewHolder) holder).title.getText().toString());

                            break;
                        case "Appetizer":
                            appetizer = 0;
                            ((ImageViewHolder) holder).quantity.setText(String.valueOf(appetizer) + "x");
                            ((ImageViewHolder) holder).button_quantity.setVisibility(View.INVISIBLE);
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
                            beverage = Integer.parseInt(((ImageViewHolder) holder).quantity.getText().toString().replace("x", ""));
                            food++;
                            ((ImageViewHolder) holder).quantity.setText(String.valueOf(food) + "x");
                            ((ImageViewHolder) holder).button_quantity.setVisibility(View.VISIBLE);
                            checkedFood.put(((ImageViewHolder) holder).title.getText().toString(), food);

                            break;
                        case "Beverage":
                            appetizer = Integer.parseInt(((ImageViewHolder) holder).quantity.getText().toString().replace("x", ""));
                            beverage++;
                            ((ImageViewHolder) holder).quantity.setText(String.valueOf(beverage) + "x");
                            ((ImageViewHolder) holder).button_quantity.setVisibility(View.VISIBLE);
                            checkedBeverage.put(((ImageViewHolder) holder).title.getText().toString(), beverage);

                            break;
                        case "Appetizer":
                            appetizer = Integer.parseInt(((ImageViewHolder) holder).quantity.getText().toString().replace("x", ""));
                            appetizer++;
                            ((ImageViewHolder) holder).quantity.setText(String.valueOf(appetizer) + "x");
                            ((ImageViewHolder) holder).button_quantity.setVisibility(View.VISIBLE);
                            checkedAppetizer.put(((ImageViewHolder) holder).title.getText().toString(), appetizer);

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

    public HashMap<String, Integer> getFood(){
        return checkedFood;
    }

    public HashMap<String, Integer> getBeverage(){
        return checkedBeverage;
    }

    public HashMap<String, Integer> getAppetizer(){
        return checkedAppetizer;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, button_quantity;
        TextView title, about, price, quantity;
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
            button_quantity = itemView.findViewById(R.id.button_quantity);
            quantity = itemView.findViewById(R.id.quantity);
            button_quantity.setVisibility(View.GONE);

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

            button_quantity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (category) {
                        case "Food":
                            beverage = Integer.parseInt(quantity.getText().toString().replace("x", ""));
                            food++;
                            quantity.setText(String.valueOf(food) + "x");
                            button_quantity.setVisibility(View.VISIBLE);
                            checkedFood.put(title.getText().toString(), food);

                            break;
                        case "Beverage":
                            appetizer = Integer.parseInt(quantity.getText().toString().replace("x", ""));
                            beverage++;
                            quantity.setText(String.valueOf(beverage) + "x");
                            button_quantity.setVisibility(View.VISIBLE);
                            checkedBeverage.put(title.getText().toString(), beverage);

                            break;
                        case "Appetizer":
                            appetizer = Integer.parseInt(quantity.getText().toString().replace("x", ""));
                            appetizer++;
                            quantity.setText(String.valueOf(appetizer) + "x");
                            button_quantity.setVisibility(View.VISIBLE);
                            checkedAppetizer.put(title.getText().toString(), appetizer);

                            break;
                        default:
                            Log.d("SELECT ITEM", "NO MORE");
                            break;
                    }
                }
            });
        }
    }

    public void setFilter(List<Data> FilteredDataList) {
        dataList = FilteredDataList;
        notifyDataSetChanged();
    }
}

