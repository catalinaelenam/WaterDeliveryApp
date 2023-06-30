package com.example.mycontactapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> implements Filterable {

    private List<String> ordersList;
    private List<String> ordersListFull;

    public OrderAdapter(List<String> ordersList) {
        this.ordersList = ordersList;
        this.ordersListFull = new ArrayList<>(ordersList);
    }

    public void setData(List<String> newData) {
        ordersList.clear();
        ordersList.addAll(newData);
        ordersListFull.clear();
        ordersListFull.addAll(newData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        String order = ordersList.get(position);
        holder.bind(order);
    }

    @Override
    public int getItemCount() {
        return ordersList.size();
    }

    @Override
    public Filter getFilter() {
        return ordersFilter;
    }

    private Filter ordersFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<String> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(ordersListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (String order : ordersListFull) {
                    if (order.toLowerCase().contains(filterPattern)) {
                        filteredList.add(order);
                    }
                }
            }

            results.values = filteredList;
            results.count = filteredList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ordersList.clear();
            ordersList.addAll((List<String>) results.values);
            notifyDataSetChanged();
        }
    };

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView orderTextView;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderTextView = itemView.findViewById(R.id.orderTextView);
        }

        public void bind(String order) {
            orderTextView.setText(order);
        }
    }
}


