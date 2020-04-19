package com.example.financeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.financeapp.Fragments.stock_add_fragment;

public class MainActivity extends AppCompatActivity {
    private stock_add_fragment mFragment_stock_add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment_stock_add = new stock_add_fragment();
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.Fragment_Container, mFragment_stock_add)
            .commit();
    }





}
