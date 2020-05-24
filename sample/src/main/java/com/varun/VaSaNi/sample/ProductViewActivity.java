package com.varun.VaSaNi.sample;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

import com.varun.VaSaNi.sample.cart.Cartmodel;

import java.util.ArrayList;
import java.util.List;

public class ProductViewActivity extends SampleActivity {

    private static int cart_count = 1;
    public TextView quantity, inc, dec;
    String _id, _title, _image, _description, _price, _currency, _discount, _attribute;
    TextView id, title, description, price, currency, discount, attribute;
    ImageView imageView;
    LinearLayout addToCart, share;
    RelativeLayout quantityLL;
    List<Cartmodel> cartList = new ArrayList<>();
    int cartId;
    Cartmodel cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);
        Log.d("Error : ","yessss");

        Intent intent = getIntent();

        _id = "1234";
        _title = intent.getStringExtra("title");
        _image = intent.getStringExtra("image");
        _description = "SAME for all for now";
        _price = intent.getStringExtra("price");
        _currency = "Rs";
        _attribute = intent.getStringExtra("attribute");

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        changeActionBarTitle(getSupportActionBar());
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //cart_count = cartCount();

        title = findViewById(R.id.apv_title);
        description = findViewById(R.id.apv_description);
        currency = findViewById(R.id.apv_currency);
        price = findViewById(R.id.apv_price);
        attribute = findViewById(R.id.apv_attribute);
        imageView = findViewById(R.id.apv_image);
        addToCart = findViewById(R.id.add_to_cart_ll);
        quantityLL = findViewById(R.id.quantity_rl);
        quantity = findViewById(R.id.quantity);
        inc = findViewById(R.id.quantity_plus);
        dec = findViewById(R.id.quantity_minus);

        //cartList = getCartList();
        title.setText(_title);
        description.setText(_description);
        price.setText(_price);
        currency.setText(_currency);
        attribute.setText(_attribute);
        discount.setText(_discount);


        if (!cartList.isEmpty()) {
            for (int i = 0; i < cartList.size(); i++) {
                if (cartList.get(i).getTitle().equalsIgnoreCase(_title)) {
                    addToCart.setVisibility(View.GONE);
                    quantityLL.setVisibility(View.VISIBLE);
                    quantity.setText(cartList.get(i).getQuantity());
                    cartId = i;

                }
            }
        }


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEntry = _image + "\n" + _title + "\n" + _description + "\n" + _attribute + "-" + _currency + _price + "(" + _discount + ")";

                Intent textShareIntent = new Intent(Intent.ACTION_SEND);
                textShareIntent.putExtra(Intent.EXTRA_TEXT, userEntry);
                textShareIntent.setType("text/plain");
                startActivity(textShareIntent);
            }
        });

    }

    private void changeActionBarTitle(ActionBar actionBar) {
        // Create a LayoutParams for TextView
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                RelativeLayout.LayoutParams.WRAP_CONTENT); // Height of TextView
        TextView tv = new TextView(getApplicationContext());
        // Apply the layout parameters to TextView widget
        tv.setLayoutParams(lp);
        tv.setGravity(Gravity.CENTER);
        tv.setTypeface(null, Typeface.BOLD);
        // Set text to display in TextView
        tv.setText(_title); // ActionBar title text
        tv.setTextSize(20);

        // Set the text color of TextView to red
        // This line change the ActionBar title text color
        tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        // Set the ActionBar display option
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // Finally, set the newly created TextView as ActionBar custom view
        actionBar.setCustomView(tv);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(ProductViewActivity.this, SampleActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                return true;

            //case R.id.cart_action:
            //    startActivity(new Intent(getApplicationContext(), CartFragment.class));
            //    return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


  /*  public void onAddProduct() {
        cart_count++;
        invalidateOptionsMenu();

    }


    public void onRemoveProduct() {
        cart_count--;
        invalidateOptionsMenu();

    }*/

}
