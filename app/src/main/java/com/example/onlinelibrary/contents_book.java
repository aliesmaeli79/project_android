package com.example.onlinelibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class contents_book extends AppCompatActivity {



    RecyclerView list_content;
    List<Books> list=new ArrayList<>();
    ApiInterface request;

    ImageView imageView_back;

    String url="http://uniproject.freecloudsite.com/data/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents_book);


        request=ApiClient.getApiClient(url).create(ApiInterface.class);

        list_content=findViewById(R.id.contents_list);

        list_content.setLayoutManager(new LinearLayoutManager(this));



        request.getdata().enqueue(new Callback<List<Books>>() {
            @Override
            public void onResponse(Call<List<Books>> call, Response<List<Books>> response) {

                list=response.body();
                ContentsListAdapter adapter=new ContentsListAdapter(list);
                list_content.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Books>> call, Throwable t) {
                Toast.makeText(contents_book.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ERROR",t.getMessage()+"");
            }
        });

    }
}