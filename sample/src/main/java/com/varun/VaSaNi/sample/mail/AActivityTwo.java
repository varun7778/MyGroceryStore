package com.varun.VaSaNi.sample.mail;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.varun.VaSaNi.sample.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.TimeUnit;
import androidx.cardview.widget.CardView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AActivityTwo extends AppCompatActivity {

    private FloatingActionButton fab;
    private CardView cvAdd;
    private Button bt_go;
    public int head=0;
    public TextInputLayout otp,one,two,three;
    private TextView tv;
    private EditText editText;
    private String verificationid;
    private FirebaseAuth mAuth;
    public String phonenumber,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        head=0;
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity_two);
        ShowEnterAnimation();
        initView();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateRevealClose();
            }
        });
        bt_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(head==0) {
                    String code = "91";
                    String number = editText.getText().toString().trim();
                    email = tv.getText().toString();

                    if (number.isEmpty() || number.length() < 10) {
                        editText.setError("Valid number is required");
                        editText.requestFocus();
                        return;
                    }
                    else{
                        three.setVisibility(v.GONE);
                        two.setVisibility(v.GONE);
                        one.setVisibility(v.GONE);
                        otp.setHint("Enter OTP");
                        tv.setText("");
                    }
                    phonenumber = "+" + code + number;

                    head=1;
                }
                else{
                    sendVerificationCode(phonenumber);
                    String code = tv.getText().toString().trim();
                    if ((code.isEmpty() || code.length() < 6)){

                        tv.setError("Enter code...");
                        tv.requestFocus();
                        return;
                    }
                    verifyCode(code);
                    Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();
                    animateRevealClose();
                }
            }
        });
    }

    private void verifyCode(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationid, code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            try
                            {
                                LongOperation l=new LongOperation();
                                l.execute();  //sends the email in background
                                Toast.makeText(getApplicationContext(), l.get(), Toast.LENGTH_SHORT).show();
                                animateRevealClose();
                            } catch (Exception e) {
                                Log.e("SendMail", e.getMessage(), e);
                            }
                        } else {
                            Toast.makeText(AActivityTwo.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                });
    }

    private void sendVerificationCode(String number){

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationid = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null){
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(AActivityTwo.this, e.getMessage(),Toast.LENGTH_LONG).show();

        }
    };


    private void initView() {
        fab = findViewById(R.id.fab);
        cvAdd = findViewById(R.id.cv_add);
        bt_go = findViewById(R.id.bt_go);
        one = findViewById(R.id.one);
        two = findViewById(R.id.three);
        three = findViewById(R.id.four);
        otp = findViewById(R.id.two);
        tv = findViewById(R.id.Email1);
        editText = findViewById(R.id.Mobile);
    }

    private void ShowEnterAnimation() {
        Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fabtransition);
        getWindow().setSharedElementEnterTransition(transition);

        transition.addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(Transition transition) {
                cvAdd.setVisibility(View.GONE);
            }

            @Override
            public void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                animateRevealShow();
            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }


        });
    }

    public void animateRevealShow() {
        Animator mAnimator = ViewAnimationUtils.createCircularReveal(cvAdd, cvAdd.getWidth()/2,0, fab.getWidth() / 2, cvAdd.getHeight());
        mAnimator.setDuration(500);
        mAnimator.setInterpolator(new AccelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                cvAdd.setVisibility(View.VISIBLE);
                super.onAnimationStart(animation);
            }
        });
        mAnimator.start();
    }

    public void animateRevealClose() {
        Animator mAnimator = ViewAnimationUtils.createCircularReveal(cvAdd,cvAdd.getWidth()/2,0, cvAdd.getHeight(), fab.getWidth() / 2);
        mAnimator.setDuration(500);
        mAnimator.setInterpolator(new AccelerateInterpolator());
        mAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                cvAdd.setVisibility(View.INVISIBLE);
                super.onAnimationEnd(animation);
                fab.setImageResource(R.drawable.plus);
                AActivityTwo.super.onBackPressed();
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
        mAnimator.start();
    }
    @Override
    public void onBackPressed() {
        animateRevealClose();
    }
}
