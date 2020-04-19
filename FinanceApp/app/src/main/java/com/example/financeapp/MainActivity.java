package com.example.financeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.financeapp.Fragments.portfolio_fragment;
import com.example.financeapp.Fragments.stock_add_fragment;

public class MainActivity extends AppCompatActivity {
    private stock_add_fragment mFragment_stock_add;
    private portfolio_fragment mPortfolioFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPortfolioFragment = new portfolio_fragment();

        getSupportFragmentManager().beginTransaction()
            .replace(R.id.Fragment_Container, mPortfolioFragment)
            .commit();
    }





}
