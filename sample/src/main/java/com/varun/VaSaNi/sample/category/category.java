package com.varun.VaSaNi.sample.category;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.varun.VaSaNi.sample.R;

import java.util.ArrayList;


public class category extends Fragment {
    RecyclerView expanderRecyclerView;

    public category() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        expanderRecyclerView = view.findViewById(R.id.View);
        ArrayList<String> parentList = new ArrayList<>();
        ArrayList<ArrayList> childListHolder = new ArrayList<>();
        ArrayList<Integer> imageList = new ArrayList<>();

        parentList.add("Fruits");
        parentList.add("Vegetables");
        parentList.add("Packages");
        imageList.add(R.drawable.fruits);
        imageList.add(R.drawable.vegetables);
        imageList.add(R.drawable.water);
        ArrayList<String> childList = new ArrayList<>();
        childList.add("Golden Delicious Apple");
        childList.add("Granny Smith Apple");
        childList.add("Pink Lady Apple");
        childList.add("Royal Gala Apple");
        childList.add("Red Delicious Apple");
        childList.add("Avocado");
        childList.add("Banana");
        childList.add("Kiwi");
        childList.add("Lemon");
        childList.add("Lime");
        childList.add("Mango");
        childList.add("Cantaloupe Melon");
        childList.add("Galia Melon");
        childList.add("Honeydew Melon");
        childList.add("Watermelon");
        childList.add("Nectarine");
        childList.add("Orange");
        childList.add("Papaya");
        childList.add("Passion-Fruit");
        childList.add("Peach");
        childList.add("Anjou Pear");
        childList.add("Conference Pear");
        childList.add("Kaiser Pear");
        childList.add("Pineapple");
        childList.add("Plum");
        childList.add("Pomegranate");
        childList.add("Red Grapefruit");
        childList.add("Satsumas");

        childListHolder.add(childList);

        childList = new ArrayList<>();
        childList.add("Asparagus");
        childList.add("Aubergine");
        childList.add("Cabbage");
        childList.add("Carrots");
        childList.add("Cucumber");
        childList.add("Garlic");
        childList.add("Ginger");
        childList.add("Leek");
        childList.add("Brown Cap Mushroom");
        childList.add("Yellow Onion");
        childList.add("Green Bell Pepper");
        childList.add("Orange Bell Pepper");
        childList.add("Red Bell Pepper");
        childList.add("Yellow Bell Pepper");
        childList.add("Floury Potato");
        childList.add("Solid Potato");
        childList.add("Sweet Potato");
        childList.add("Red Beet");
        childList.add("Beef Tomato");
        childList.add("Regular Tomato");
        childList.add("Vine Tomato");
        childList.add("Zucchini");

        childListHolder.add(childList);

        childList = new ArrayList<>();
        childList.add("Bravo Apple Juice");
        childList.add("Bravo Orange Juice");
        childList.add("God Morgon Apple Juice");
        childList.add("God Morgon Orange Juice");
        childList.add("God Morgon Orange Red Grapefruit Juice");
        childList.add("God Morgon Red Grapefruit Juice");
        childList.add("Tropicana Apple Juice");
        childList.add("Tropicana Golden Grapefruit");
        childList.add("Tropicana Juice Smooth");
        childList.add("Tropicana Mandarin Morning");
        childList.add("Arla Ecological Medium Fat Milk");
        childList.add("Arla Lactose Medium Fat Milk");
        childList.add("Arla Medium Fat Milk");
        childList.add("Arla Standard Milk");
        childList.add("Garant Ecological Medium Fat Milk");
        childList.add("Garant Ecological Standard Milk");
        childList.add("Oatly Natural Oatghurt");
        childList.add("Oatly Oat Milk");
        childList.add("Arla Ecological Sour Cream");
        childList.add("Arla Sour Cream");
        childList.add("Arla Sour Milk");
        childList.add("Alpro Blueberry Soyghurt");
        childList.add("Alpro Vanilla Soyghurt");
        childList.add("Alpro Fresh Soy Milk");
        childList.add("Alpro Shelf Soy Milk");
        childList.add("Arla Mild Vanilla Yoghurt");
        childList.add("Arla Natural Mild Low Fat Yoghurt");
        childList.add("Arla Natural Yoghurt");
        childList.add("Valio Vanilla Yoghurt");
        childList.add("Yoggi Strawberry Yoghurt");
        childList.add("Yoggi Vanilla Yoghurt");

        childListHolder.add(childList);

        ExpandableRecyclerViewAdapter expandableCategoryRecyclerViewAdapter = new ExpandableRecyclerViewAdapter(getContext(), parentList, childListHolder,imageList);
        expanderRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        expanderRecyclerView.setAdapter(expandableCategoryRecyclerViewAdapter);
        return view;
    }

}
