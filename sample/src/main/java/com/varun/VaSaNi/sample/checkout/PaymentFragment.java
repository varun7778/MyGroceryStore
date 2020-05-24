package com.varun.VaSaNi.sample.checkout;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.varun.VaSaNi.sample.R;

public class PaymentFragment extends Fragment {

    RadioGroup paymentGroup;
    FrameLayout cardFrame;
    LinearLayout payll;
    TextView pay;

    public PaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_payment, container, false);
        paymentGroup = view.findViewById(R.id.payment_group);
        cardFrame = view.findViewById(R.id.card_frame);
        payll = view.findViewById(R.id.pay_ll);
        pay = view.findViewById(R.id.total_pay);
        Double amount = 420.69;
        pay.append(amount + "");
        payll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(paymentGroup.getCheckedRadioButtonId()!=-1)
                {
                    int selectedId = paymentGroup.getCheckedRadioButtonId();
                    RadioButton radioButton = view.findViewById(selectedId);
                    if (radioButton.getId() == R.id.cash_on_delivery) {
                        Bundle bundle = new Bundle();
                        bundle.putString("key","3");
                        ConfirmFragment frag = new ConfirmFragment();
                        frag.setArguments(bundle);
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        Toast.makeText(getContext(),radioButton.getText()+"", Toast.LENGTH_LONG).show();
                        ft.replace(R.id.content_frame,frag);
                        ft.commit();
                    }
                    if (radioButton.getId() == R.id.Gpay) {
                        Bundle bundle = new Bundle();
                        bundle.putString("key","2");
                        ConfirmFragment frag = new ConfirmFragment();
                        frag.setArguments(bundle);
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        Toast.makeText(getContext(),radioButton.getText()+"", Toast.LENGTH_LONG).show();
                        ft.replace(R.id.content_frame, frag);
                        ft.commit();
                    }
                    if (radioButton.getId() == R.id.card_payment) {
                        Bundle bundle = new Bundle();
                        bundle.putString("key","1");
                        ConfirmFragment frag = new ConfirmFragment();
                        frag.setArguments(bundle);
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        Toast.makeText(getContext(),radioButton.getText()+"", Toast.LENGTH_LONG).show();
                        ft.replace(R.id.content_frame, frag);
                        ft.commit();
                    }
                }
            }
        });
                return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Payment");
    }
}
