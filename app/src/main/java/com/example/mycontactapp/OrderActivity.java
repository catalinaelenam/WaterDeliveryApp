package com.example.mycontactapp;


import android.os.Bundle;

import com.example.mycontactapp.databinding.ActivityOrderBinding;

public class OrderActivity extends DrawerBaseActivity {

    ActivityOrderBinding activityOrderBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityOrderBinding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(activityOrderBinding.getRoot());
        allocateActivityTitle("Orders");
    }
}