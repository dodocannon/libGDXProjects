package com.example.financeapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.anychart.scales.Base;
import com.anychart.scales.Linear;
import com.example.financeapp.FinanceAdapter;
import com.example.financeapp.R;
import com.example.financeapp.Stock;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class portfolio_fragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManger;
    private ArrayList<Stock> stockList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.portfolio_frag, container, false);

        setRetainInstance(true);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        stockList = new ArrayList<>();

        stockList.add(new Stock("aapl", "apple company", "3000", "-3%", "-3@#$@", 500));

        ImageButton mImageButton = view.findViewById(R.id.mAddButton);

        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stock_add_fragment saf = new stock_add_fragment();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction fragmentTransaction = manager.beginTransaction();
                fragmentTransaction.add(R.id.Fragment_Container, saf);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        });
        mRecyclerView = view.findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManger = new LinearLayoutManager(getContext());
        mAdapter = new FinanceAdapter(stockList);

        mRecyclerView.setLayoutManager(mLayoutManger);
        mRecyclerView.setAdapter(mAdapter);

    }

    public void addStock(Stock mStockAdd)
    {
        System.out.println("ADDDED1");
       stockList.add(0,mStockAdd);
        stockList.add(new Stock("aapl", "apple company", "3030", "-3%","-3@#$@", 500));
       mAdapter.notifyDataSetChanged();
    }
    public void updateStocks()
    {

    }
}
