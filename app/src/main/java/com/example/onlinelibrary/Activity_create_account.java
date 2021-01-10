package com.example.onlinelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Activity_create_account extends AppCompatActivity {
    AppCompatButton create;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        create = findViewById(R.id.button_create);
        checkBox = findViewById(R.id.checkbox_tick);


        if (create.isClickable()) {
            create.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Activity_create_account.this, MainActivity.class);
                    startActivity(i);
                }
            });
        }


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.getId() == checkBox.getId()) {
                    if (isChecked) {
                        create.setEnabled(true);
                    } else {
                        create.setEnabled(false);
                    }
                }
            }
        });
    }
}