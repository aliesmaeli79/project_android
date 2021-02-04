package com.example.onlinelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import static com.example.onlinelibrary.MainActivity.database;
import static com.example.onlinelibrary.MainActivity.userAccount;

public class Fragment_guide extends Fragment {


    AppCompatButton button_delete;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_account_me, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button_delete = view.findViewById(R.id.btn_delete);

        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.deleteFromDb(userAccount);

                Intent intent =new Intent(view.getContext(),MainActivity.class);

                Toast.makeText(view.getContext(), "اکانت با موفقیت حذف شد", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}
