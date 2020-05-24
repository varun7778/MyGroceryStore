package com.varun.VaSaNi.sample.cart;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.varun.VaSaNi.sample.Data;
import com.varun.VaSaNi.sample.R;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    ArrayList<Cartmodel> data;


    public CartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_cart, container, false);
        data = new ArrayList<>();
        for (int i = 0; i < Data.titleArray.length; i++) {
            data.add(new Cartmodel(
                    Data.titleArray[i],
                    Data.drawableArray[i],
                    Data.currArray[i],
                    Data.priceArray[i],
                    Data.attributeArray[i],
                    Data.quantArray[i],
                    Data.totalArray[i]
            ));
        }
        recyclerView = view.findViewById(R.id.cart_rv);
        adapter = new CartAdapter(getContext(), data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return view;

    }

    }
