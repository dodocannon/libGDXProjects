package com.example.financeapp;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FinanceAdapter extends RecyclerView.Adapter<FinanceAdapter.FinanceViewHolder> {
    private ArrayList<Stock> mPortfolioList;
    private onItemClickListener mListener;

    public FinanceAdapter(ArrayList<Stock> mPortfolioList) {
        this.mPortfolioList = mPortfolioList;
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public FinanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview2, parent, false);
        FinanceViewHolder mFinanceViewHolder = new FinanceViewHolder(v, mListener);

        return mFinanceViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FinanceViewHolder holder, int position) {
        Stock mCurrentStock = mPortfolioList.get(position);


        holder.mName.setText(mCurrentStock.getName());
        holder.mFullName.setText(mCurrentStock.getFullName());
        holder.mDayChange.setText("Day: " + mCurrentStock.getDayChange());
        holder.mCurrPrice.setText(mCurrentStock.getCurrentSharePrice());
        holder.mBoughtPrice.setText(mCurrentStock.getBoughtSharePrice());
        holder.mNetChange.setText(mCurrentStock.getNetChange());
        holder.mQuantity.setText("Quantity: " + mCurrentStock.getShares());
        holder.mMarketValue.setText("Market Value: " + mCurrentStock.getMarketValue());
        if (mCurrentStock.getDayChange().contains("-")) {
            holder.mDayChange.setTextColor(Color.parseColor("#ff0000"));
        } else {

            holder.mDayChange.setTextColor(Color.parseColor("#00ff00"));
        }
    }

    @Override
    public int getItemCount() {
        return mPortfolioList.size();
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    public static class FinanceViewHolder extends RecyclerView.ViewHolder {
        public TextView mName, mFullName, mCurrPrice, mNetChange, mQuantity, mDayChange, mBoughtPrice, mMarketValue;

        public FinanceViewHolder(final View itemView, final onItemClickListener listener) {
            super(itemView);
            mName = itemView.findViewById(R.id.textView1_1);
            mFullName = itemView.findViewById(R.id.textView1_2);
            mBoughtPrice = itemView.findViewById(R.id.textView1_4);
            mCurrPrice = itemView.findViewById(R.id.textView1_3);
            mDayChange = itemView.findViewById(R.id.textView1_6);
            mNetChange = itemView.findViewById(R.id.textView1_5);
            mQuantity = itemView.findViewById(R.id.textView1_7);
            mMarketValue = itemView.findViewById(R.id.textView1_8);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Toast.makeText(itemView.getContext(),"LONG CLICK",Toast.LENGTH_LONG).show();
                    itemView.setBackgroundColor(Color.GREEN);
                    return true;
                }
            });
        }

    }
}
