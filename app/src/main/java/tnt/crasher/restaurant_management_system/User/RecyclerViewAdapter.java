package tnt.crasher.restaurant_management_system.User;

import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.List;

import tnt.crasher.restaurant_management_system.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Data> dataList;

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
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((ImageViewHolder) holder).imageView.setImageResource(dataList.get(position).photo);
        ((ImageViewHolder) holder).title.setText(dataList.get(position).title);
        ((ImageViewHolder) holder).about.setText(dataList.get(position).about);
        ((ImageViewHolder) holder).ratingBar.setRating(dataList.get(position).rating);
        ((ImageViewHolder) holder).price.setText(dataList.get(position).price);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((ImageViewHolder) holder).checkBox.isChecked())
                    ((ImageViewHolder) holder).checkBox.setChecked(false);
                else{
                    ((ImageViewHolder) holder).checkBox.setChecked(true);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
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
        }
    }

    public void setFilter(List<Data> FilteredDataList) {
        dataList = FilteredDataList;
        notifyDataSetChanged();
    }
}

