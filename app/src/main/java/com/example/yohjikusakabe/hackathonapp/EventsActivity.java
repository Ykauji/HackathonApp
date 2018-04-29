package com.example.yohjikusakabe.hackathonapp;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;

public class EventsActivity extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View v;
    public EventsActivity() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static EventsActivity newInstance(String param1, String param2) {
        EventsActivity fragment = new EventsActivity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_events, container, false);
        ImageButton imageButton = v.findViewById(R.id.imageButton98);
        ImageButton imageButton1 = v.findViewById(R.id.imageButton101);

        Glide.with(this).load(R.drawable.placeholderposter).centerCrop().into(imageButton);
        Glide.with(this).load(R.drawable.placeholder2).centerCrop().into(imageButton1);
        return v;
    }

}
