package com.example.onlinelibrary;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Activity_after_sign_in extends AppCompatActivity {

    RecyclerView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sign_in);

        list = findViewById(R.id.list_main);



        list.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Object> listItem=generateItems();

        ListAdapter adapter=new ListAdapter(listItem);
        list.setAdapter(adapter);
    }

    private ArrayList<Object> generateItems() {
        ArrayList<Object> data = new ArrayList<>();

        ArrayList<BannerItem> bannerItems=new ArrayList<>();
        bannerItems.add(new BannerItem(R.drawable.banner));
        bannerItems.add(new BannerItem(R.drawable.banner));
        bannerItems.add(new BannerItem(R.drawable.banner));
        BannerListItem bannerListItem = new BannerListItem(bannerItems);
        data.add(bannerListItem);

        ArrayList<AppItem> appItems=new ArrayList<>();
        appItems.add(new AppItem("بيشتر بدانيد  ",R.drawable.more));
        appItems.add(new AppItem("مقالات علمی  ",R.drawable.scientific_articles));
        appItems.add(new AppItem("حلقه های     ",R.drawable.reading_circles));
        appItems.add(new AppItem("برنامه مطالعاتی",R.drawable.studyprogram));

        AppListItem appListItem=new AppListItem(appItems);
        data.add(appListItem);

        ArrayList<BookItem> bookItems =new ArrayList<>();
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));
        bookItems.add(new BookItem(R.drawable.book_test));

        BookListItem bookListItem=new BookListItem("پربازدیدترینها",bookItems);
        data.add(bookListItem);

        ArrayList<BookItem> bookItems1 =new ArrayList<>();
        bookItems1.add(new BookItem(R.drawable.book_test));
        bookItems1.add(new BookItem(R.drawable.book_test));
        bookItems1.add(new BookItem(R.drawable.book_test));
        bookItems1.add(new BookItem(R.drawable.book_test));
        bookItems1.add(new BookItem(R.drawable.book_test));
        bookItems1.add(new BookItem(R.drawable.book_test));

        BookListItem bookListItem1=new BookListItem("پرفروش ترینها",bookItems);
        data.add(bookListItem1);

        ArrayList<BookItem> bookItems2 =new ArrayList<>();
        bookItems2.add(new BookItem(R.drawable.book_test));
        bookItems2.add(new BookItem(R.drawable.book_test));
        bookItems2.add(new BookItem(R.drawable.book_test));
        bookItems2.add(new BookItem(R.drawable.book_test));
        bookItems2.add(new BookItem(R.drawable.book_test));
        bookItems2.add(new BookItem(R.drawable.book_test));

        BookListItem bookListItem2=new BookListItem("جدید ترین ها",bookItems);
        data.add(bookListItem2);

        return data;

    }
}