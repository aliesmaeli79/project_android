package com.example.onlinelibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;

public class FragmentAccountMe extends Fragment {



   private CounterImage counterImage=new CounterImage();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guide, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button1;
        Button button2;
        ImageView imageView;


        imageView=view.findViewById(R.id.image_guid);
        button1=view.findViewById(R.id.btn_new);
        button2=view.findViewById(R.id.btn_old);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counterImage.getCounter()==0){
                    counterImage.setCounter(counterImage.getCounter()+1);
                    imageView.setImageResource(R.drawable.image1);
                }
                else if(counterImage.getCounter()==1){
                    counterImage.setCounter(counterImage.getCounter()+1);
                    imageView.setImageResource(R.drawable.image2);
                }
                else if(counterImage.getCounter()==2){
                    counterImage.setCounter(counterImage.getCounter()+1);
                    imageView.setImageResource(R.drawable.image3);
                }
                else if(counterImage.getCounter()==3){
                    counterImage.setCounter(counterImage.getCounter()+1);
                    imageView.setImageResource(R.drawable.image4);
                }
                else if(counterImage.getCounter()==4){
                    counterImage.setCounter(counterImage.getCounter()+1);
                    imageView.setImageResource(R.drawable.image5);
                }
                else if(counterImage.getCounter()==5){
                    counterImage.setCounter(counterImage.getCounter()+1);
                    imageView.setImageResource(R.drawable.image6);
                }
                else if(counterImage.getCounter()==6){
                    imageView.setImageResource(R.drawable.image7);
                }
                else{

                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counterImage.getCounter()==0){
                }
                else if(counterImage.getCounter()==1){
                    counterImage.setCounter(counterImage.getCounter()-1);
                    imageView.setImageResource(R.drawable.image1);
                }
                else if(counterImage.getCounter()==2){
                    counterImage.setCounter(counterImage.getCounter()-1);
                    imageView.setImageResource(R.drawable.image2);
                }
                else if(counterImage.getCounter()==3){
                    counterImage.setCounter(counterImage.getCounter()-1);
                    imageView.setImageResource(R.drawable.image3);
                }
                else if(counterImage.getCounter()==4){
                    counterImage.setCounter(counterImage.getCounter()-1);
                    imageView.setImageResource(R.drawable.image4);
                }
                else if(counterImage.getCounter()==5){
                    counterImage.setCounter(counterImage.getCounter()-1);
                    imageView.setImageResource(R.drawable.image5);
                }
                else if(counterImage.getCounter()==6){
                    counterImage.setCounter(counterImage.getCounter()-1);
                    imageView.setImageResource(R.drawable.image6);
                }
                else if(counterImage.getCounter()>6){
                    counterImage.setCounter(counterImage.getCounter()-1);
                }
                else{

                }
            }
        });

    }
}
