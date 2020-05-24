package com.varun.VaSaNi.sample.checkout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.varun.VaSaNi.sample.R;
import com.varun.VaSaNi.sample.cart.AddressFragment;

public class outActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        Log.d("Tag1","in activity");
        FrameLayout f1 = findViewById(R.id.content_frame);
        f1.removeAllViews();
        FragmentManager fragmentManager = getSupportFragmentManager();
        androidx.fragment.app.Fragment fragment = new AddressFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
    }
}
