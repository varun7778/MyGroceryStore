package com.varun.VaSaNi.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.varun.VaSaNi.sample.cart.Cartmodel;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
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
        Intent intent = getIntent();

        _id = "1234";
        _title = intent.getStringExtra("title");
        _image = intent.getStringExtra("image");
        _description = "SAME for all for now";
        _price = intent.getStringExtra("price");
        _currency = "Rs";
        _attribute = intent.getStringExtra("attribute");
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

        title.setText(_title);
        description.setText(_description);
        price.setText(_price);
        currency.setText(_currency);
        attribute.setText(_attribute);
        discount.setText(_discount);
    }
}
