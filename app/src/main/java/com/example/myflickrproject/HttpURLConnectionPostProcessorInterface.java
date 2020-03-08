package com.example.myflickrproject;

/**
 * Created by masoud on 2017-06-20.
 */

public interface HttpURLConnectionPostProcessorInterface {

    void successHandler(String data);
    void failureHandler(Exception exception);
}
