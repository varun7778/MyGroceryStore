package com.varun.VaSaNi.sample.popular;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.varun.VaSaNi.sample.R;
import com.varun.VaSaNi.sample.Data;

import java.util.ArrayList;
import java.util.concurrent.Executor;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class pitemsFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    private ProductsAdapter adapter;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }


    public pitemsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pitems, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        FirebaseRecyclerOptions<ProductsClass> options =
                new FirebaseRecyclerOptions.Builder<ProductsClass>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Fruits"), ProductsClass.class)
                        .build();
        adapter = new ProductsAdapter(options);
        recyclerView.setAdapter(adapter);


        return view;

    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            // do your stuff
            FirebaseUser currentUser = mAuth.getCurrentUser();
            updateUI(currentUser);
        } else {
            signInAnonymously();
        }
    }

    private void signInAnonymously() {
        mAuth.signInAnonymously().addOnSuccessListener((Activity) getContext(), new  OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                // do your stuff
            }
        })
                .addOnFailureListener((Activity) getContext(), new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Log.e(TAG, "signInAnonymously:FAILURE", exception);
                    }
                });
    }

    private void updateUI(FirebaseUser currentUser) {
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}

