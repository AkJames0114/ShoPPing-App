package com.jamshidbek.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.databinding.ActivitySendCodeBinding;

public class SendCodeActivity extends BaseActivity<ActivitySendCodeBinding> {

    String[] passCodeString = new String[4];

    int passCodeCounter = 0;
    @Override
    protected ActivitySendCodeBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivitySendCodeBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding.verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendCodeActivity.this, ResetPassword.class);
                startActivity(intent);
            }
        });
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendCodeActivity.this, ForgotPassword.class);
                startActivity(intent);
            }
        });

        binding.passcode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                String number = s.toString();
                if (number.length()== 1){
                    binding.passcode1.requestFocus();/*bu function etPasswordda 10ta characterdan keyn
                                                           ozi pasgi qismga auto otishni taminlaydi*/
                }
            }
        });


    }
}