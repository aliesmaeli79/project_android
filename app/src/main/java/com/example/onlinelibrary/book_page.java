package com.example.onlinelibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.onlinelibrary.Contacts.REQUEST_CODE;

public class book_page extends AppCompatActivity {

    TextView name_author;
    TextView name_book;
    TextView genre;
    TextView price;
    TextView explanation;
    ImageView imageView;
    Button download;
    RatingBar ratingBar;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_page);



        name_author=findViewById(R.id.text_author);
        name_book=findViewById(R.id.text_name_book);
        genre=findViewById(R.id.text_genre);
        price=findViewById(R.id.text_price);
        explanation=findViewById(R.id.text_book);
        imageView=findViewById(R.id.image_book_page);

        ratingBar=findViewById(R.id
                .rating_bar_book);

        download=findViewById(R.id.button_download);

        back=findViewById(R.id.back);

        String name_book1 =getIntent().getStringExtra("name_book");
        if(name_book1!=null) {
            name_book.setText(name_book1);
        }
        String name_author1 =getIntent().getStringExtra("name_author");
        if(name_author1!=null) {
            name_author.setText(name_author1);
        }
        String genre1 =getIntent().getStringExtra("genre");
        if(genre1!=null) {
            genre.setText(genre1);
        }
        String price1=getIntent().getStringExtra("price");
        if(price1!=null) {
            price.setText(price1);
        }
        String explanation1=getIntent().getStringExtra("explanation");
        if(explanation1!=null) {
            explanation.setText(explanation1);
        }
        float rate1=getIntent().getFloatExtra("rate",3);
        if(rate1!=0) {
            ratingBar.setRating(rate1);
        }

        String image1=getIntent().getStringExtra("image");
        if(image1!=null) {
            Picasso.get().load(image1).into(imageView);
        }


        String download1=getIntent().getStringExtra("link");
        if(download1!=null) {
            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(download1));
                    v.getContext().startActivity(browserIntent);
                }
            });
        }


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(book_page.this,contents_book.class);
                setResult(REQUEST_CODE,intent);
                finish();
            }
        });
    }
}