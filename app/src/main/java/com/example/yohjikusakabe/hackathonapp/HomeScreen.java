package com.example.yohjikusakabe.hackathonapp;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class HomeScreen extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View m;
    private MapView mMapView;
    private GoogleMap mGoogleMap;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeScreen() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeScreen newInstance(String param1, String param2) {
        HomeScreen fragment = new HomeScreen();
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
        m = inflater.inflate(R.layout.fragment_home_screen, container, false);
        ImageButton imageButton = m.findViewById(R.id.imageButton3);
        ImageView mapPic;
        mapPic = m.findViewById(R.id.mapViewStatic);
        int relativeWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, getResources().getDisplayMetrics());
        int relativeHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 275, getResources().getDisplayMetrics());
        Glide.with(this).load(R.drawable.placeholderposter).centerCrop().into(imageButton);
        String testAddress = "55 Lexington Ave, New York, NY 10010, USA";
        Glide.with(this).load("https://maps.googleapis.com/maps/api/staticmap?center=" + testAddress + "&markers=" + testAddress + "&zoom=16&size=400x400&key=AIzaSyC-WUHOsJ5-IvQfVvvUUnI-B04-jpwjphE").centerCrop().into(mapPic);
        // Dynamic event creation, takes input from database. Address is geocoded and static map is created.
        createNewEvent("Spooki Party","https://cdn2.glstock.com/29157/4409351/4409351_325.jpg","695 Park Ave. NY","This is a very spooky party. Please come in costume for free admittance! Free food and drinks and at the end of the day we will hold a raffle.","April 30, 2018 6:00 pm - 10:00 pm");
        createNewEvent("Jim's Potato Celebration","https://cafedelites.com/wp-content/uploads/2017/10/Crispy-Garlic-Roasted-Potatoes-IMAGE-18-500x500.jpg","6 varick street,NY","We will be serving Jim's signature puffy potatoes at this great party. If you wish to participate please come early! It's first come first serve.","April 29, 2018 1:00 pm - 5:00 pm");
        return m;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
    }

    // Dynamic relative layout creation.
    public void createNewEvent(String name,String picURL,String address,String information,String date) {
        RelativeLayout r = new RelativeLayout(getActivity());
        LinearLayout LinearParent = m.findViewById(R.id.linearParent);
        ImageButton button = new ImageButton(getActivity());
        ImageView mapStaticView = new ImageView(getActivity());
        TextView locationText = new TextView(getActivity());
        button.setId(m.generateViewId());
        Button notifyMe = m.findViewById(R.id.notifyMe);
        notifyMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Added to your events!", Toast.LENGTH_SHORT).show();
            }
        });

        TextView eventName = new TextView(getActivity());
        TextView locationBox = new TextView(getActivity());
        TextView informationBox = new TextView(getActivity());
        TextView timeBox = new TextView(getActivity());
        informationBox.setId(m.generateViewId());
        TextView littleLine = new TextView(getActivity());
        TextView about = new TextView(getActivity());

        // Relative Layout
        int relativeWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 360, getResources().getDisplayMetrics());
        r.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        ));
        // Image layout
        int relativeHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 260, getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams paramsImage = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                relativeHeight
        );
        paramsImage.addRule(RelativeLayout.ALIGN_PARENT_START);
        paramsImage.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        mapStaticView.setAdjustViewBounds(true);
        // That little line
        int relativeHeightLine = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, getResources().getDisplayMetrics());
        int relativeWidthLine = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());
        int relativeHeightOffset = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams paramsLine = new RelativeLayout.LayoutParams(
                relativeWidthLine,
                relativeHeightLine
        );
        paramsLine.addRule(RelativeLayout.CENTER_HORIZONTAL);
        paramsLine.addRule(RelativeLayout.BELOW,button.getId());
        littleLine.setBackgroundColor(Color.parseColor("#f4cc70"));
        littleLine.setLayoutParams(paramsLine);
        littleLine.setId(m.generateViewId());

        // Event Name
        RelativeLayout.LayoutParams paramsName = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        paramsName.addRule(RelativeLayout.BELOW,button.getId());
        paramsName.setMargins(0,relativeHeightOffset,0,0);
        paramsName.addRule(r.CENTER_HORIZONTAL);
        paramsName.addRule(r.BELOW,littleLine.getId());
        eventName.setLayoutParams(paramsName);
        eventName.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        eventName.setTextColor(Color.BLACK);
        eventName.setText(name);
        eventName.setId(m.generateViewId());

        // Location stuff
        RelativeLayout.LayoutParams paramsLocation = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        paramsLocation.addRule(RelativeLayout.BELOW,eventName.getId());
        paramsLocation.setMargins(0,0,0,0);
        paramsLocation.addRule(r.CENTER_HORIZONTAL);
        paramsLocation.addRule(r.BELOW,eventName.getId());
        locationBox.setLayoutParams(paramsLocation);
        locationBox.setText(address);
        locationBox.setId(m.generateViewId());

        // Time stuff
        RelativeLayout.LayoutParams paramsTime = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        paramsTime.addRule(r.BELOW,locationBox.getId());
        paramsTime.addRule(r.CENTER_HORIZONTAL);
        timeBox.setText(date);
        timeBox.setId(m.generateViewId());

        // About stuff
        RelativeLayout.LayoutParams paramsAbout = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        paramsAbout.addRule(RelativeLayout.BELOW,timeBox.getId());
        paramsAbout.setMargins(relativeHeightOffset,0,0,0);
        paramsAbout.addRule(r.BELOW,timeBox.getId());
        about.setText("About:");
        about.setTextColor(Color.parseColor("#20948b"));
        about.setLayoutParams(paramsAbout);
        about.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        about.setId(m.generateViewId());

        // Info stuff
        int relativeWidthInfo = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 340, getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams paramsInfo = new RelativeLayout.LayoutParams(
                relativeWidthInfo,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        paramsInfo.addRule(RelativeLayout.BELOW,about.getId());
        paramsInfo.addRule(RelativeLayout.ALIGN_START,1);
        paramsInfo.setMargins(relativeHeightOffset,0,0,0);
        informationBox.setText(information);
        informationBox.setTextSize(TypedValue.COMPLEX_UNIT_SP,15);
        informationBox.setId(m.generateViewId());

        // Location Text
        RelativeLayout.LayoutParams paramsLocationText = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        paramsLocationText.addRule(r.BELOW,informationBox.getId());
        paramsLocationText.setMargins(0,14,0,0);
        paramsLocationText.addRule(r.ALIGN_START,about.getId());
        locationText.setText("Location:");
        locationText.setTextColor(Color.parseColor("#20948b"));
        locationText.setId(m.generateViewId());

        // Map Image
        int relativeHeightLine2 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics());
        int relativeHeightMap = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams paramsMap = new RelativeLayout.LayoutParams(
                relativeWidth,
                relativeHeightMap
        );
        paramsMap.setMargins(0,relativeHeightLine2,0,0);
        paramsMap.addRule(r.BELOW,locationText.getId());
        mapStaticView.setId(m.generateViewId());

        // Notify me
        Button notifyMeBut = new Button(getActivity());
        notifyMeBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Added to your events!", Toast.LENGTH_SHORT).show();
            }
        });
        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        buttonParams.addRule(r.BELOW,mapStaticView.getId());
        buttonParams.addRule(r.CENTER_HORIZONTAL);
        notifyMeBut.setText("Notify me!");

        Glide.with(this).load("https://maps.googleapis.com/maps/api/staticmap?center=" + address + "&markers=" + address + "&zoom=16&size=400x400&key=AIzaSyC-WUHOsJ5-IvQfVvvUUnI-B04-jpwjphE").centerCrop().into(mapStaticView);
        Glide.with(this).load(picURL).centerCrop().into(button);

        r.addView(button,paramsImage);
        r.addView(littleLine,paramsLine);
        r.addView(eventName,paramsName);
        r.addView(locationBox,paramsLocation);
        r.addView(timeBox,paramsTime);
        r.addView(about,paramsAbout);
        r.addView(informationBox,paramsInfo);
        r.addView(locationText,paramsLocationText);
        r.addView(mapStaticView,paramsMap);
        r.addView(notifyMeBut,buttonParams);

        LinearParent.addView(r);
    }

}
