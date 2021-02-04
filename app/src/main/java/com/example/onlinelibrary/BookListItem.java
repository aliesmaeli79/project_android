package com.example.onlinelibrary;

import java.util.ArrayList;

public class BookListItem {

    private ArrayList<Books> items;
    private String title;

    public BookListItem(String title, ArrayList<Books> items) {
        this.items=new ArrayList<>();
        this.items.addAll(items);
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Books> getItems() {
        return items;
    }

    public void setItems(ArrayList<Books> items) {
        this.items = items;
    }
}
