package com.example.mycontactapp;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;


public class OrderActivity extends DrawerBaseActivity {

    private List<String> ordersList;
    private OrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        allocateActivityTitle("Orders");

        ordersList = new ArrayList<>();
        // RecycleView Configuration
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        OrderAdapter adapter = new OrderAdapter(ordersList);
        recyclerView.setAdapter(adapter);

        // SearchView Configuration
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        // Initialize Order list
        List<String> ordersList = new ArrayList<>();
        ordersList.add("Aquafina - 3");
        ordersList.add("IceMountain - 10");
        ordersList.add("SmartWater - 1");

        // Add orders in adapter
        adapter.setData(ordersList);
    }
}
