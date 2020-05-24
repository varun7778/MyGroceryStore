package com.varun.VaSaNi.sample.Recomendation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.varun.VaSaNi.sample.Recomendation.itemsmodel;
import com.varun.VaSaNi.sample.R;

import java.util.ArrayList;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private ArrayList<itemsmodel> dataSet;
    private Context mContext;

    public MyRecyclerViewAdapter(Context context, ArrayList<itemsmodel> data) {
        this.dataSet = data;
        this.mContext = context;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {

        ImageView image = holder.image;
        TextView title = holder.title;
        TextView Quantity = holder.Quantity;
        TextView addtoc = holder.add;
        TextView price = holder.price;

        image.setImageResource(dataSet.get(listPosition).getImage());
        title.setText(dataSet.get(listPosition).getTitle());
        Quantity.setText(dataSet.get(listPosition).getQuantity());
        price.setText(dataSet.get(listPosition).getPrice());
        addtoc.setText("Add To Cart");

        /*holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductViewActivity.class);
                //intent.putExtra("id", Model.getId());
                intent.putExtra("title", dataSet.get(listPosition).getTitle());
                intent.putExtra("image", dataSet.get(listPosition).getImage());
                intent.putExtra("price", dataSet.get(listPosition).getPrice());
                intent.putExtra("attribute", dataSet.get(listPosition).getQuantity());


                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                mContext.startActivity(intent);
            }
        });*/
    }


    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView Quantity;
        TextView add;
        TextView price;
        CardView cardView;
        /*make changes here*/
        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image);
            this.title = itemView.findViewById(R.id.title);
            this.Quantity = itemView.findViewById(R.id.Quatitiy);
            this.add = itemView.findViewById(R.id.addtoc);
            this.price = itemView.findViewById(R.id.price);
            this.cardView = itemView.findViewById(R.id.cardView);

        }
    }
}