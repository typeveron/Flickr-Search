package com.example.myflickrproject;

import com.example.myflickrproject.model.DataCollection;
import com.example.myflickrproject.model.Photo;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonManagment {


    public static String processJSONData(String data) {

        String content = "";
        String farm = "";
        String server = "";
        String secret = "";
        String id = "";
        String title = "";

        DataCollection.photoList.clear();

        try {

            JSONObject jsonObject = new JSONObject(data);
            JSONObject photos = jsonObject.getJSONObject("photos");
            JSONArray jsonArray = photos.getJSONArray("photo");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                farm = object.getString("farm");
                secret = object.getString("secret");
                server = object.getString("server");
                id = object.getString("id");
                title = object.getString("title");
                content = "https://farm" + farm + ".staticflickr.com/" + server + "/" + id + "_" + secret + ".jpg";
                Photo myPhoto = new Photo(content,title);
                DataCollection.photoList.add(myPhoto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }
}







