package com.varun.VaSaNi.sample;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;


import com.varun.VaSaNi.SlidingRootNav;
import com.varun.VaSaNi.SlidingRootNavBuilder;
import com.varun.VaSaNi.sample.Myprofile.ProfileFragment;
import com.varun.VaSaNi.sample.Recomendation.recoFragment;
import com.varun.VaSaNi.sample.cart.CartFragment;
import com.varun.VaSaNi.sample.checkout.outActivity;
import com.varun.VaSaNi.sample.category.category;
import com.varun.VaSaNi.sample.menu.DrawerAdapter;
import com.varun.VaSaNi.sample.menu.DrawerItem;
import com.varun.VaSaNi.sample.menu.SimpleItem;
import com.varun.VaSaNi.sample.order.orderFragment;
import com.varun.VaSaNi.sample.popular.pitemsFragment;

import java.util.Arrays;


public class SampleActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {

    private static final int POS_HOME = 0;
    private static final int POS_ACCOUNT = 1;
    private static final int POS_CART = 5;
    private static final int POS_NEW = 3;
    private static final int POS_POPULAR = 4;
    private static final int POS_CATEGORY = 2;
    private static final int POS_ORDERS = 6;
    private static final int POS_LOGOUT = 7;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Toolbar toolbar = findViewById(R.id.toolbar1);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_HOME).setChecked(true),
                createItemFor(POS_ACCOUNT),
                createItemFor(POS_CART),
                createItemFor(POS_NEW),
                createItemFor(POS_POPULAR),
                createItemFor(POS_CATEGORY),
                createItemFor(POS_ORDERS),
                createItemFor(POS_LOGOUT)));
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_HOME);

    }

    public void buttonClick(View v) {
        switch(v.getId()) {
            case R.id.buttons:
                startActivity(new Intent(SampleActivity.this, outActivity.class));
                break;

            //case R.id.cardView:
                //Intent intent = new Intent(SampleActivity.this, ProductActivity.class);
                //intent.putExtra("title",R.id.title);
                //startActivity(intent);
                //break;
        }
    }

    @Override
    public void onItemSelected(int position) {
        if (position == POS_LOGOUT) {
            finish();
        }
        slidingRootNav.closeMenu();
        FrameLayout f1 = findViewById(R.id.container);
        f1.removeAllViews();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(position == 1) {
            androidx.fragment.app.Fragment fragment = new ProfileFragment();
            Toolbar toolbar = findViewById(R.id.toolbar1);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Profile");
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if(position==2)
        {
            androidx.fragment.app.Fragment fragment = new category();
            Toolbar toolbar = findViewById(R.id.toolbar1);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Categories");
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if(position == 3) {
            androidx.fragment.app.Fragment fragment = new recoFragment();
            Toolbar toolbar = findViewById(R.id.toolbar1);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Recommendations");
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if(position == 4) {
            androidx.fragment.app.Fragment fragment = new pitemsFragment();
            Toolbar toolbar = findViewById(R.id.toolbar1);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Popular Items");
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if(position==5)
        {
            androidx.fragment.app.Fragment fragment = new CartFragment();
            Toolbar toolbar = findViewById(R.id.toolbar1);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Cart");
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if(position==6)
        {
            androidx.fragment.app.Fragment fragment = new orderFragment();
            Toolbar toolbar = findViewById(R.id.toolbar1);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Orders");
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }
        if(position==0) {

            androidx.fragment.app.Fragment fragment = new Dashboard();
            Toolbar toolbar = findViewById(R.id.toolbar1);
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("");
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }

    }

    private void showFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.textColorSecondary))
                .withTextTint(color(R.color.textColorPrimary))
                .withSelectedIconTint(color(R.color.colorAccent))
                .withSelectedTextTint(color(R.color.colorAccent));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;

    }



    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }

    public Double getTotalPrice() {
        Double total = 50.6;
        return total;
    }
}
