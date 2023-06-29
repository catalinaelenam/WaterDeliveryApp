package com.example.mycontactapp;



import android.os.Bundle;

import com.example.mycontactapp.databinding.ActivityCustomersBinding;

public class CustomersActivity extends DrawerBaseActivity {

    ActivityCustomersBinding activityCustomersBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCustomersBinding = ActivityCustomersBinding.inflate(getLayoutInflater());
        setContentView(activityCustomersBinding.getRoot());
        allocateActivityTitle("Customers");
    }
}