package com.example.myflickrproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Person;
import android.os.Bundle;

import com.example.myflickrproject.model.DataCollection;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoListActivity extends AppCompatActivity {

    @BindView(R.id.recView)
    RecyclerView recyclerV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_list);
        ButterKnife.bind(this);

        PhotoAdapter myAdapter = new PhotoAdapter(DataCollection.photoList,this);
        recyclerV.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerV.setAdapter(myAdapter);
    }
}
