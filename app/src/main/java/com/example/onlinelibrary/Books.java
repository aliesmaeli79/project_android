package com.example.onlinelibrary;

import java.util.List;

public class Books {

    List<Books> data;


    private String id,name,price,author,pic_link,download_link,published,description;

    private float rate;

    public String getPic_link() {
        return pic_link;
    }

    public float getRate() {
        return rate;
    }

    public String getId() {
        return id;
    }

    public String getDownload_link() {
        return download_link;
    }

    public String getPublished() {
        return published;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }



    public String getAuthor() {
        return author;
    }


    public String getPrice() {
        return price;
    }


}
