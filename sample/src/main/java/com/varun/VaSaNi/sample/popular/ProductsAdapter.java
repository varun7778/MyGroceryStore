package com.varun.VaSaNi.sample.popular;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.varun.VaSaNi.sample.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class ProductsAdapter extends FirebaseRecyclerAdapter<ProductsClass, ProductsAdapter.ProductViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public String urlImage;
    public ProductsAdapter(@NonNull FirebaseRecyclerOptions<ProductsClass> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull ProductsClass card_layout) {

        holder.a.setText(String.valueOf(card_layout.getNames()));
        holder.b.setText(String.valueOf(card_layout.getPrice()));
        holder.c.setText(String.valueOf(card_layout.getQuantity()));
        //FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseStorage storage  = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        storageRef.child("Images/"+ card_layout.getId()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                urlImage = uri.toString();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                urlImage="fuck";
            }
        });
        if(true)
        {
            Log.e("HEY", "FAILURE");
            Glide.with(holder.itemView.getContext())
                    .load(urlImage)
                    .centerCrop()
                    .into(holder.d);
        }
        else {
            Glide.with(holder.itemView.getContext()).clear(holder.d);
        }
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);

        return new ProductViewHolder(view);
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{

        TextView a, b, c;
        ImageView d;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            a=itemView.findViewById((R.id.title));
            b=itemView.findViewById(R.id.price);
            c=itemView.findViewById((R.id.Quatitiy));
            d=itemView.findViewById(R.id.image);
        }
    }
}
