package com.varun.VaSaNi.sample.category;

import android.content.Context;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.varun.VaSaNi.sample.R;

import java.util.ArrayList;

public class ExpandableRecyclerViewAdapter extends RecyclerView.Adapter<ExpandableRecyclerViewAdapter.ViewHolder> {

    ArrayList<String> nameList = new ArrayList<String>();
    ArrayList<Integer> image = new ArrayList<Integer>();
    ArrayList<Integer> counter = new ArrayList<Integer>();
    ArrayList<ArrayList> itemNameList = new ArrayList<ArrayList>();
    Context context;

    public ExpandableRecyclerViewAdapter(Context context, ArrayList<String> nameList, ArrayList<ArrayList> itemNameList, ArrayList<Integer>  imageList) {
        this.nameList = nameList;
        this.itemNameList = itemNameList;
        this.context = context;
        this.image = imageList;


        for (int i = 0; i < nameList.size(); i++) {
            counter.add(0);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageButton dropBtn;
        RecyclerView cardRecyclerView;
        CardView cardView;
        ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.categoryTitle);
            dropBtn = itemView.findViewById(R.id.categoryExpandBtn);
            cardRecyclerView = itemView.findViewById(R.id.innerRecyclerView);
            cardView = itemView.findViewById(R.id.cardView);
            img = itemView.findViewById(R.id.img);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_collapseview, parent, false);

        ExpandableRecyclerViewAdapter.ViewHolder vh = new ExpandableRecyclerViewAdapter.ViewHolder(v);

        return vh;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.name.setText(nameList.get(position));
        holder.img.setImageResource(image.get(position));

        InnerRecyclerViewAdapter itemInnerRecyclerView = new InnerRecyclerViewAdapter(itemNameList.get(position));


        holder.cardRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (counter.get(position) % 2 == 0) {
                    holder.cardRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    holder.cardRecyclerView.setVisibility(View.GONE);
                }

                counter.set(position, counter.get(position) + 1);


            }
        });
        holder.cardRecyclerView.setAdapter(itemInnerRecyclerView);

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }


}
