package com.example.myflickrproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPhoto extends AppCompatActivity {

    @BindView(R.id.imagePhotoLink)
    ImageView thePhoto;

    @BindView(R.id.textBelow)
    TextView textBelow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_photo);
        ButterKnife.bind(this);


        //recieve data
        Intent intent = getIntent();
        String title = intent.getExtras().getString("title");
        String link = intent.getExtras().getString("photo");

        //set values
        textBelow.setText(title);
        Glide.with(this).asBitmap()
                .load(link)
                .centerCrop()
                //.apply(option)
                .into(thePhoto);

    }
}
