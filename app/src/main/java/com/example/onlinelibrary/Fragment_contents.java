package com.example.onlinelibrary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment_contents extends Fragment {

    RecyclerView list;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contents, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        list = view.findViewById(R.id.list_contents);
        list.setLayoutManager(new LinearLayoutManager(getActivity()));

        int resId = R.anim.layout_animation_down_up;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(view.getContext(), resId);
        list.setLayoutAnimation(animation);

        ArrayList<SubjectListItem> listItem = generateSubject();

        SubjectListAdapter adapter=new SubjectListAdapter(listItem);

        list.setAdapter(adapter);


    }

    private ArrayList<SubjectListItem> generateSubject(){
        ArrayList<SubjectListItem> data = new ArrayList<>();


        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_children));
        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_academic));
        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_foreign_language));
        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_historical));
        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_life_style));
        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_psychology));
        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_relief));
        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_social));
        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_sport));
        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_philosophical));
        data.add(new SubjectListItem(R.drawable.history_text,R.drawable.subject_story));

        return data;

    }
}
