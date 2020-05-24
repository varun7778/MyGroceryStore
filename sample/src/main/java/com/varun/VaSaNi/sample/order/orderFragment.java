package com.varun.VaSaNi.sample.order;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.varun.VaSaNi.sample.Data;
import com.varun.VaSaNi.sample.R;

import java.util.ArrayList;

public class orderFragment extends Fragment {
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    ArrayList<Ordermodel> data;

    public orderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        data = new ArrayList<>();
        for (int i = 0; i < Data.idArray.length; i++) {
            data.add(new Ordermodel(
                    Data.drawableArray[i],
                    Data.idArray[i],
                    Data.orderIdArray[i],
                    Data.dateArray[i],
                    Data.totalArray[i],
                    Data.statusArray[i]
            ));
        }
        recyclerView = view.findViewById(R.id.order_rv);
        adapter = new orderadapter(getContext(), data);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;

    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("My Orders");
    }

}
