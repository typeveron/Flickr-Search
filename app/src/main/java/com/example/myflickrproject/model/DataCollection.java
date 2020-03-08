package com.example.myflickrproject.model;

import java.util.ArrayList;

public class DataCollection {
    public static ArrayList<Photo> photoList = new ArrayList<>();

    public DataCollection() {
    }

    public static ArrayList<Photo> getListOfPhoto() {
        return photoList;
    }

    public static void setPhotoList(ArrayList<Photo> photoList) {
        DataCollection.photoList = photoList;
    }
}
