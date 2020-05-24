package com.varun.VaSaNi.sample.category;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.varun.VaSaNi.sample.R;

import java.util.ArrayList;


public class InnerRecyclerViewAdapter extends RecyclerView.Adapter<InnerRecyclerViewAdapter.ViewHolder> {
    public ArrayList<String> nameList = new ArrayList<String>();

    public InnerRecyclerViewAdapter(ArrayList<String> nameList) {

        this.nameList = nameList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemTextView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_expand_item_view, parent, false);


        InnerRecyclerViewAdapter.ViewHolder vh = new InnerRecyclerViewAdapter.ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(nameList.get(position));

    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }


}
