package com.example.onlinelibrary;

import java.util.ArrayList;

public class BookListItem {

    private ArrayList<BookItem> items;
    private String title;

    public BookListItem(String title, ArrayList<BookItem> items) {
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

    public ArrayList<BookItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BookItem> items) {
        this.items = items;
    }
}
