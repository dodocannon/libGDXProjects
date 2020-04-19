package com.example.financeapp.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.financeapp.R;
import com.example.financeapp.Scraper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class stock_add_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.stock_add_frag, container, false);
        final AutoCompleteTextView mAutoCompleteTextView = v.findViewById(R.id.mAutoCompleteTextView);
        final CardView mCardView1 = v.findViewById(R.id.mCardView1);
        final String[] stocklist = getResources().getStringArray(R.array.stocklist);


        Toolbar mtoolbar = v.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mtoolbar);



        //TODO make custom list item https://github.com/aosp-mirror/platform_frameworks_base/blob/master/core/res/res/layout/simple_list_item_1.xml
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, stocklist );

        mAutoCompleteTextView.setAdapter(adapter);

        mAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String mStockSelected = parent.getItemAtPosition(position).toString();
                String[] mStockArr = Scraper.getData(mStockSelected.substring(0, mStockSelected.indexOf(" ")));
                TextView mTextView1 = v.findViewById(R.id.textView1);
                TextView mTextView2 = v.findViewById(R.id.textView2);
                TextView mTextView3 = v.findViewById(R.id.textView3);
                TextView mTextView4 = v.findViewById(R.id.textView4);
                TextView mTextView5 = v.findViewById(R.id.textView5);
                TextView mTextView6 = v.findViewById(R.id.textView6);
                mTextView1.setText(mStockSelected.split(" ")[0]);
                mTextView2.setText(mStockSelected.substring(mStockSelected.indexOf(" "), mStockSelected.length()));
                mTextView3.setText(mStockArr[1]);
                mTextView4.setText("As of recent");
                mTextView5.setText(mStockArr[2].split(" ")[0]);
                mTextView6.setText(mStockArr[2].split(" ")[1]);

                if(mTextView5.getText().toString().contains("-"))
                {
                    mTextView5.setTextColor(Color.RED);
                    mTextView6.setTextColor(Color.RED);
                }
                else
                {
                    mTextView5.setTextColor(Color.GREEN);
                    mTextView6.setTextColor(Color.GREEN);
                }
                System.out.println("POSISISON" + position);
                mCardView1.setVisibility(View.VISIBLE);


            }
        });
        mAutoCompleteTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(mAutoCompleteTextView.getText().toString().trim().length()==0)
                {
                    mCardView1.setVisibility(View.GONE);
                }
            }
        });





        return v;
    }
}

