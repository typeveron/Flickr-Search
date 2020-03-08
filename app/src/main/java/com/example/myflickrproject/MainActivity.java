package com.example.myflickrproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myflickrproject.model.DataCollection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, HttpURLConnectionPostProcessorInterface {

    @BindView(R.id.editText)
    EditText photoTopic;

    @BindView(R.id.button)
    Button search;


    public String searchUrl;
    String searchKey;
    String per_page;
    String photoUrl;
    String tag_mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.button, R.id.upload})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                searchPressed();
                break;
            case R.id.upload:
                takePhoto();
                break;
        }
    }


        public void searchPressed() {
            String API_KEY = "e41e15460a1577f9efdba97e2c8bb251";
            searchKey = photoTopic.getText().toString();
            tag_mode = "any";
            per_page="100";

            //http://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=e41e15460a1577f9efdba97e2c8bb251&tags=apple&per_page=100&format=json&nojsoncallback=1
            searchUrl = "https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=" + API_KEY
                    + "&tags=" + searchKey
                    + "&tag_mode=" + tag_mode
                    + "&per_page=" + per_page
                    + "&format=json&nojsoncallback=1";

            System.out.println(" Search pressed: The url is " + searchUrl);
            AsyncFlicker asynchronousHttpURLConnector = new AsyncFlicker(searchUrl,this);

            // 2- Will run in background
            asynchronousHttpURLConnector.execute();


        }


    public void takePhoto() {
           Intent intent = new Intent(this, UploadPhoto.class);
           startActivity(intent);
    }


    public void goToOtherActivity() {
        Intent intent = new Intent(this, PhotoListActivity.class);
        startActivity(intent);
    }


    @Override
    public void successHandler(String dataInJSON) {

        photoUrl = JsonManagment.processJSONData(dataInJSON);

        System.out.println(" Data collection print: "+ DataCollection.photoList);
        System.out.println("The url is " + photoUrl);
        goToOtherActivity();
    }

    @Override
    public void failureHandler(Exception exception) {


    }
}

