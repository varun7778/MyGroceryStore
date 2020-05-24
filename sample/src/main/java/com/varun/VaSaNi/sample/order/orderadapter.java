package com.varun.VaSaNi.sample.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.varun.VaSaNi.sample.R;

import java.util.ArrayList;

public class orderadapter extends RecyclerView.Adapter<orderadapter.ViewHolder> {

    private ArrayList<Ordermodel> dataSet;
    private Context mContext;

    public orderadapter(Context context, ArrayList<Ordermodel> data) {
        this.dataSet = data;
        mContext = context;
    }

    public orderadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_layout, parent, false);
        orderadapter.ViewHolder viewHolder = new orderadapter.ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(final orderadapter.ViewHolder holder, final int listPosition) {

        ImageView image = holder.image;
        TextView orderid= holder.orderid;
        TextView date = holder.date;
        TextView total = holder.total;
        TextView status = holder.status;

        image.setImageResource(dataSet.get(listPosition).getImage());
        orderid.setText(dataSet.get(listPosition).getOrderId());
        date.setText(dataSet.get(listPosition).getDate());
        total.setText(dataSet.get(listPosition).getTotal());
        status.setText(dataSet.get(listPosition).getStatus());
    }

    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView orderid;
        TextView date;
        TextView total;
        TextView status;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.imageView4);
            this.orderid = itemView.findViewById(R.id.order_id);
            this.date = itemView.findViewById(R.id.date);
            this.total = itemView.findViewById(R.id.total_amount);
            this.status = itemView.findViewById(R.id.status);
        }
    }
}