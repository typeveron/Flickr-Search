package com.example.myflickrproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UploadPhoto extends AppCompatActivity {

    @BindView(R.id.photoButton)
    Button photoButton;

    @BindView(R.id.yourPhoto)
    ImageView whatITook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.photoButton})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.photoButton:
                takeThePhoto();
        }
    }



    public void takeThePhoto() {
          Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
          startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        whatITook.setImageBitmap(bitmap);
    }
}
