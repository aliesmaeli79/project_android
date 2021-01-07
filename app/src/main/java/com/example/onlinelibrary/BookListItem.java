package com.example.onlinelibrary;

import java.util.ArrayList;

public class BookListItem {

    private ArrayList<BookItem> items;

    public BookListItem( ArrayList<BookItem> items) {
        this.items=new ArrayList<>();
        this.items.addAll(items);
    }

    public ArrayList<BookItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BookItem> items) {
        this.items = items;
    }
}
