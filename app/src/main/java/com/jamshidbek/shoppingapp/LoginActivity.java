package com.jamshidbek.shoppingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
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
                if (email.length()== 15){
                    binding.passwordEditText.requestFocus();/*bu function etPasswordda 10ta characterdan keyn
                                                           ozi pasgi qismga auto otishni taminlaydi*/
                }
            }
        });


        //Eye show hide button logic!
        binding.showHideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected = binding.showHideBtn.isSelected();

                //current state: isSelected => true next state: !isSelected => false
                //current state: isSelected => false next state: !isSelected => true
                if (!isSelected){
                    //hide password
                    //---1st method
                    // binding.passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    //---2nd method
                    binding.passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                }else {
                    //show password
                    //---1st method
                    //binding.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //---2nd method
                    binding.passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                }

                binding.showHideBtn.setSelected(!isSelected);
            }
        });

        //Travel between Activities
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        binding.forgotPswBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPassword.class);
                startActivity(intent);
            }
        });
        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
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