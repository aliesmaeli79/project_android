package com.example.onlinelibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

public class Fragment_setting extends Fragment {

    EditText name_new,password_old,password_new,email_new;
    ImageView name_arrow,password_arrow, email_arrow;
    LinearLayout name_box,password_box, email_box;
    AppCompatButton name_button,password_button, email_button;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name_box = view.findViewById(R.id.change_name_box);
        password_box = view.findViewById(R.id.change_password_box);
        email_box = view.findViewById(R.id.change_email_box);

        name_arrow = view.findViewById(R.id.arrow_name);
        password_arrow = view.findViewById(R.id.arrow_password);
        email_arrow = view.findViewById(R.id.arrow_email);

        name_new = view.findViewById(R.id.name_new_setting);
        password_old = view.findViewById(R.id.password_past_setting);
        password_new = view.findViewById(R.id.password_new_setting);
        email_new = view.findViewById(R.id.email_new_setting);
        
        name_button = view.findViewById(R.id.button_name_setting);
        password_button = view.findViewById(R.id.button_password_setting);
        email_button = view.findViewById(R.id.button_email_setting);



    }
}
