package com.example.financeapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FinanceAdapter extends RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder> {
    private ArrayList<Stock> mPortfolioList;



    public static class FinanceViewHolder extends RecyclerView.ViewHolder {
        public TextView mName, mFullName, mPrice, mPercentChange;

        public FinanceViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.textView1_1);
            mFullName = itemView.findViewById(R.id.textView1_2);
            mPrice = itemView.findViewById(R.id.textView1_5);
            mPercentChange = itemView.findViewById(R.id.textView1_6);
        }
    }

    public FinanceAdapter(ArrayList<Stock> mPortfolioList)
    {
        this.mPortfolioList  = mPortfolioList;
    }
    @NonNull
    @Override
    public FinanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview2,parent, false);
        FinanceViewHolder mFinanceViewHolder = new FinanceViewHolder(v);

        return mFinanceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FinanceViewHolder holder, int position) {
        Stock mCurrentStock = mPortfolioList.get(position);

        holder.mName.setText(mCurrentStock.getName());
        holder.mFullName.setText(mCurrentStock.getFullName());
        holder.mPercentChange.setText(mCurrentStock.getPercentChange());
        holder.mPrice.setText(mCurrentStock.getPrice());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
