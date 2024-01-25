package com.jamshidbek.shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.databinding.ActivityPasswordChangedBinding;

public class PasswordChangedActivity extends BaseActivity<ActivityPasswordChangedBinding> {
    @Override
    protected ActivityPasswordChangedBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityPasswordChangedBinding.inflate(inflater);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.backToLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordChangedActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}