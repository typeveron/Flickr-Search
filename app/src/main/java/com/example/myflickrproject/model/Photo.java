package com.example.myflickrproject.model;

public class Photo {
    String photoLink;
    String photoDescription;



    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(String photoDescription) {
        this.photoDescription = photoDescription;
    }

    @Override
    public String toString() {
        return
        ", photoURL='" + photoLink + '\'' +
                ", title='" + photoDescription;
    }

    public Photo(String photoLink, String photoDescription) {
        this.photoLink = photoLink;
        this.photoDescription = photoDescription;



    }
}

