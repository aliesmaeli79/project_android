package com.example.onlinelibrary;

import java.util.List;

public class Books {

    List<Books> data;


    private String id,name,price,genre,author,pic_link,download_link,published,description;

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }



    private float rate;
    private int count;

    public int getCount() {
        return count;
    }

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
