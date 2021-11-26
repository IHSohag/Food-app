package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    public static ClickListener clickListener;
    Context context;
    int images[];
    String foodNames[];
    String foodPrice[];
    String descriptionNames[];

    public CustomAdapter(Context context, int images[], String foodNames[], String descriptionNames[] ,String foodPrice[]) {
        this.context = context;
        this.images = images;
        this.foodNames = foodNames;
        this.descriptionNames = descriptionNames;
        this.foodPrice = foodPrice;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.sample_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.titleTextView.setText(foodNames[position]);
        holder.descTextView.setText(descriptionNames[position]);
        holder.priceTextView.setText(foodPrice[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        ImageView imageView;
        TextView titleTextView,priceTextView,descTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewId);
            titleTextView = itemView.findViewById(R.id.titleTextViewId);
            priceTextView = itemView.findViewById(R.id.priceTextViewId);
            descTextView = itemView.findViewById(R.id.descriptinTextViewID);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(),view);
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }
    public interface ClickListener{
        void onItemClick(int position,View view);
    }
    public void setOnItemClickListener (ClickListener clickListener){
        CustomAdapter.clickListener = clickListener;
    }
}
