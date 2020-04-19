package com.example.financeapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.scales.Linear;
import com.example.financeapp.FinanceAdapter;
import com.example.financeapp.R;
import com.example.financeapp.Stock;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class portfolio_fragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManger;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.portfolio_frag, container, false);
        ArrayList<Stock> stockList = new ArrayList<>();

        stockList.add(new Stock("aapl", "apple company", "3000", "-3%"));
        mRecyclerView = v.findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManger = new LinearLayoutManager(getContext());
        mAdapter = new FinanceAdapter(stockList);

        mRecyclerView.setLayoutManager(mLayoutManger);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }
}
