package com.jamshidbek.shoppingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    @Override
    protected ActivityLoginBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityLoginBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //How to show verified email icon:
        //1.Check email:
        //  1.Email need to contain '@' and index of '@' should be over than 0
        //      invalid input: @gmail.com
        //  2.Email need to contain '.' after '@' index
        //      invalid input: test@gmail. 1.test@.com 2.test@gmail.
        // We check it in two place: 1. Login btn clicked. 2. While input text by user.

        //Listen input text
        binding.emailEditText.addTextChangedListener(new TextWatcher() {
            //before text change
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            //on text change: s is the input char
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            //After text changed
            @Override
            public void afterTextChanged(Editable s) {
                String email = s.toString();
//                if (email.contains("@") && email.indexOf('@') != 0) {
//                    String tail = email.substring(email.indexOf('@'));
//                    if (tail.contains(".")
//                            && tail.indexOf('.')!=1
//                            && email.lastIndexOf('.') != (email.length() - 1)) {
//                        binding.icVerifiedEmail.setVisibility(View.VISIBLE);
//                    } else {
//                        binding.icVerifiedEmail.setVisibility(View.INVISIBLE);
//                    }
//
//                } else {
//                    binding.icVerifiedEmail.setVisibility(View.INVISIBLE);
//                }

                binding.icVerifiedEmail.setVisibility(isEmailValid(email) ? View.VISIBLE : View.INVISIBLE);
//
            }
        });
    }

    private boolean isEmailValid(String email) {
        boolean isValid = false;
        if (email.contains("@") && email.indexOf('@') != 0) {
            String tail = email.substring(email.indexOf('@'));
            if (tail.contains(".")
                    && tail.indexOf('.') != 1
                    && email.lastIndexOf('.') != (email.length() - 1)) {
                isValid = true;
            }
        }
        return isValid;
    }
}