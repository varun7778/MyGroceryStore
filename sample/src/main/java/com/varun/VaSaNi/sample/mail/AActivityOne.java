package com.varun.VaSaNi.sample.mail;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.varun.VaSaNi.sample.R;
import com.varun.VaSaNi.sample.SampleActivity;

import androidx.core.app.ActivityOptionsCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AActivityOne extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btGo;
    private CardView cv;
    private FloatingActionButton fab;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_one);
        initView();
        tv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                try
                {
                    LongOperation l=new LongOperation();
                    l.execute();  //sends the email in background
                    Toast.makeText(getApplicationContext(), l.get(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
            }
        });
        setListener();
    }

    private void initView() {
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btGo = findViewById(R.id.bt_go);
        cv = findViewById(R.id.cv);
        fab = findViewById(R.id.fab);
        tv=(TextView)findViewById(R.id.forgot);
    }

    private void setListener() {
        btGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Explode explode = new Explode();
                explode.setDuration(500);

                getWindow().setExitTransition(explode);
                getWindow().setEnterTransition(explode);
                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(AActivityOne.this);
                Intent i2 = new Intent(AActivityOne.this, SampleActivity.class);
                startActivity(i2, oc2.toBundle());
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getWindow().setExitTransition(null);
                getWindow().setEnterTransition(null);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(AActivityOne.this, fab, fab.getTransitionName());
                startActivity(new Intent(AActivityOne.this, AActivityTwo.class), options.toBundle());
            }
        });
    }

    /*@Override
    protected void onRestart() {
        super.onRestart();
        fab.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        fab.setVisibility(View.VISIBLE);
    }*/
}
