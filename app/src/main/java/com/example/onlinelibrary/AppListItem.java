package com.example.onlinelibrary;

import java.util.ArrayList;

public class AppListItem {
    private String title;
    private ArrayList<AppItem> items;

    public AppListItem(String title, ArrayList<AppItem> items) {
        this.title=title;
        this.items=new ArrayList<>();
        this.items.addAll(items);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<AppItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<AppItem> items) {
        this.items = items;
    }
}
