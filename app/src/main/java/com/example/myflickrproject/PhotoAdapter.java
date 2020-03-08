package com.example.myflickrproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myflickrproject.model.Photo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private ArrayList<Photo> photoList;
    private Context context;
    RequestOptions option;


    public PhotoAdapter(ArrayList<Photo> photoList, Context context) {
        this.photoList = photoList;
        this.context = context;


        //request glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.cardview_photo, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        System.out.println("the photolist is " + photoList);
        final Photo photo = photoList.get(position);


        //Load image with glide
        Glide.with(context).asBitmap()
                .load(photo.getPhotoLink())
                .centerCrop()
                .apply(option)
                .into(holder.image_a);


        //Load text
        holder.description.setText(photo.getPhotoDescription());


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailPhoto.class);
                intent.putExtra("title", photo.getPhotoDescription());
                intent.putExtra("photo", photo.getPhotoLink());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return this.photoList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView image_a;
        public final TextView description;
        public final CardView cardView;


        public ViewHolder(@NonNull View view) {
            super(view);
            this.description = (TextView) view.findViewById(R.id.textTitle);
            this.image_a = (ImageView) view.findViewById(R.id.titleImage);
            cardView = (CardView) view.findViewById(R.id.cardView);
        }
    }
}










