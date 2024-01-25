package com.jamshidbek.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;

import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.databinding.ActivityResetPasswordBinding;

public class ResetPassword extends BaseActivity<ActivityResetPasswordBinding> {

    @Override
    protected ActivityResetPasswordBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityResetPasswordBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPassword.this, SendCodeActivity.class);
                startActivity(intent);
            }
        });
        binding.resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPassword.this, PasswordChangedActivity.class);
                startActivity(intent);
            }
        });
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResetPassword.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        //Eye show hide button logic! => for New Password
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
        //Eye show hide button logic! => for Confirm Password
        binding.showHideBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected = binding.showHideBtnConfirm.isSelected();
                //current state: isSelected => true next state: !isSelected => false
                //current state: isSelected => false next state: !isSelected => true
                if (!isSelected){
                    //hide password
                    //---1st method
                    // binding.passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    //---2nd method
                    binding.confirmPassEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                }else {
                    //show password
                    //---1st method
                    //binding.passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    //---2nd method
                    binding.confirmPassEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                binding.showHideBtnConfirm.setSelected(!isSelected);
            }
        });
    }
}