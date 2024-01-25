package com.jamshidbek.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;

import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends BaseActivity<ActivityRegisterBinding> {

    @Override
    protected ActivityRegisterBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityRegisterBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        //Eye show hide button logic!
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

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}