package com.example.onlinelibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.onlinelibrary.GlobalRequestItem.RESPONSE_ITEM;
import static com.example.onlinelibrary.Subject_to_Book.SPECIFIC_BOOKS;

public class contents_book extends AppCompatActivity {



    RecyclerView list_content;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents_book);



        list_content=findViewById(R.id.contents_list);
//
        list_content.setLayoutManager(new LinearLayoutManager(this));

        if(SPECIFIC_BOOKS.size()!=0) {
            ContentsListAdapter adapter = new ContentsListAdapter(SPECIFIC_BOOKS);

            list_content.setAdapter(adapter);
        }



    }
}