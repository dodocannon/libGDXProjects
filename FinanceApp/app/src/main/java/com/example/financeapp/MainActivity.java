package com.example.financeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.financeapp.Fragments.portfolio_fragment;
import com.example.financeapp.Fragments.stock_add_fragment;

public class MainActivity extends AppCompatActivity implements stock_add_fragment.stockAddFragmentListener {
    private stock_add_fragment mFragment_stock_add;
    private portfolio_fragment mPortfolioFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPortfolioFragment = new portfolio_fragment();

        setTitle("jeffy time");
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.Fragment_Container, mPortfolioFragment)
            .commit();
    }


    @Override
    public void stockAdd(Stock stockName) {
        mPortfolioFragment.addStock(stockName);
    }
}
