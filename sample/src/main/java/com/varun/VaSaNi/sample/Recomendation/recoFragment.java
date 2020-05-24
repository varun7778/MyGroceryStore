package com.varun.VaSaNi.sample.Recomendation;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.varun.VaSaNi.sample.R;
import com.varun.VaSaNi.sample.Data;

import java.util.ArrayList;

public class recoFragment extends Fragment {
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<itemsmodel> data;


    public recoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nitems, container, false);
        data = new ArrayList<>();
        for (int i = 0; i < Data.titleArray.length; i++) {
            data.add(new itemsmodel(
                    Data.drawableArray[i],
                    Data.titleArray[i],
                    Data.priceArray[i],
                    Data.attributeArray[i]
            ));
        }
        recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new MyRecyclerViewAdapter(getContext(), data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;

    }
    }

