package com.example.financeapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class portfolio_fragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mRecyclerView;
    private FinanceAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManger;
    private ArrayList<Stock> stockList;
    private SwipeRefreshLayout refresher;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.portfolio_frag, container, false);


        return v;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        stockList = new ArrayList<>();
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
        mAdapter.setOnItemClickListener(new FinanceAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), stockList.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });

        mRecyclerView.setLayoutManager(mLayoutManger);
        mRecyclerView.setAdapter(mAdapter);


       refresher = view.findViewById(R.id.refreshLayout);
        refresher.setOnRefreshListener(this);
        refresher.post(new Runnable() {

            @Override
            public void run() {

                refresher.setRefreshing(true);

                // Fetching data from server
                updateStocks();
            }
        });

    }

    @Override
    public void onRefresh() {
        updateStocks();
    }
    public void updateStocks()
    {
        refresher.setRefreshing(true);

        for (Stock s : stockList)
        {
            s.updatesShare();
        }
        mAdapter.notifyDataSetChanged();
        refresher.setRefreshing(false);
    }

    public void addStock(Stock mStockAdd)
    {
       System.out.println("ADDDED1");
       stockList.add(0,mStockAdd);
       mAdapter.notifyDataSetChanged();
    }
    /*public void updateStocks()
    {
        for (Stock s : stockList)
        {
            s
        }
    }*/
}
