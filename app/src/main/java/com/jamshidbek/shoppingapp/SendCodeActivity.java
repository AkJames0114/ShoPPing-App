package com.jamshidbek.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.databinding.ActivitySendCodeBinding;

public class SendCodeActivity extends BaseActivity<ActivitySendCodeBinding> {

    private EditText[] editTexts;
    private int currentEditTextIndex = 0;

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
        binding.passcode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Code to automatically move focus to the next EditText if the length is 1!!
        //-->1. An array editTexts is created to hold references to the EditText views.
        editTexts = new EditText[]{binding.passcode1, binding.passcode2, binding.passcode3, binding.passcode4};
        //-->2. The setFocusChangeListener method sets up a TextWatcher for each EditText in the array, except the last one.
        setFocusChangeListener();

    }
    private void setFocusChangeListener() {
        for (int i = 0; i < editTexts.length - 1; i++) {
            // i = 0 and continues as long as i is less than editTexts.length - 1.
            // The -1 is used to make sure that the last EditText in the array is not included in the loop.
            // This is because the TextWatcher is being set up for each EditText except the last one.
            final int currentIndex = i;

            //The currentIndex is the index of the EditText being processed in the loop.
            //editTexts[currentIndex]
            editTexts[currentIndex].addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    if (s.length() == 1) {
                        moveToNextEditText(currentIndex);
                    }
                }
                @Override
                public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
                }
                @Override
                public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                }
            });
        }
    }
    private void moveToNextEditText(int currentIndex) {
        if (currentIndex < editTexts.length - 1) { /*In Java, array indices start from 0,
            so the last index is one less than the total number of elements.
            If its true, davom etish uchun ohirgi edittext masligini anglatadi*/
            currentEditTextIndex = currentIndex + 1;
            editTexts[currentEditTextIndex].requestFocus();
        }
    }
}