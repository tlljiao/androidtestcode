package com.example.cjiao.listviewtest;

/**
 * Created by cjiao on 4/2/15.
 */
public class Cartoon {
    private String name;
    private int imageId;

    public Cartoon(String name, int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
