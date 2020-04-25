package com.example.dscrecyclerviewandalertdialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OurRecyclerViewAdapter extends RecyclerView.Adapter<OurRecyclerViewAdapter.FirstHolder> {

    private ArrayList<ImageModel> picturesArray;
    private SelectionPropagator observer;

    public OurRecyclerViewAdapter(ArrayList<ImageModel> picturesArray, SelectionPropagator observer) {
        this.picturesArray = picturesArray;
        this.observer = observer;
    }

    @NonNull
    @Override
    public FirstHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new FirstHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FirstHolder holder, int position) {
        final ImageModel currentImage = picturesArray.get(position);
        holder.title.setText(currentImage.getName());
        holder.image.setImageResource(currentImage.getImage());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observer.propagateSelection(currentImage);
            }
        });
    }

    @Override
    public int getItemCount() {
        return picturesArray.size();
    }

    public class FirstHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView image;
        public FirstHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);
            image = itemView.findViewById(R.id.imageView);

        }
    }

    public interface SelectionPropagator{
        void propagateSelection(ImageModel image);
    }
}
