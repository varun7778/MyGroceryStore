package com.varun.VaSaNi.sample.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.varun.VaSaNi.sample.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private ArrayList<Cartmodel> dataSet;
    private Context mContext;

    public CartAdapter(Context context, ArrayList<Cartmodel> data) {
        this.dataSet = data;
        mContext = context;
    }

    public CartAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_layout, parent, false);
        CartAdapter.ViewHolder viewHolder = new CartAdapter.ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(final CartAdapter.ViewHolder holder, final int listPosition) {

        TextView title = holder.title;
        ImageView image = holder.image;
        TextView currency = holder.currency;
        TextView price = holder.price;
        TextView attribute = holder.attribute;
        TextView quantity = holder.quantity;
        TextView subToatal = holder.subTotal;

        title.setText(dataSet.get(listPosition).getTitle());
        image.setImageResource(dataSet.get(listPosition).getImage());
        currency.setText(dataSet.get(listPosition).getCurrency());
        price.setText(dataSet.get(listPosition).getPrice());
        attribute.setText(dataSet.get(listPosition).getAttribute());
        quantity.setText(dataSet.get(listPosition).getQuantity());
        subToatal.setText(dataSet.get(listPosition).getSubTotal());
    }

    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        ImageView image;
        TextView title;
        TextView currency;
        TextView price;
        TextView attribute;
        TextView quantity;
        TextView subTotal;

        public ViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.product_image);
            this.title = itemView.findViewById(R.id.product_title);
            this.currency = itemView.findViewById(R.id.product_currency);
            this.price = itemView.findViewById(R.id.product_price);
            this.attribute = itemView.findViewById(R.id.product_attribute);
            this.quantity = itemView.findViewById(R.id.quantity);
            this.subTotal = itemView.findViewById(R.id.sub_total);

        }
    }
}