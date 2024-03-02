package com.jamshidbek.shoppingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;

import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.Base.PreferenceManager;
import com.jamshidbek.shoppingapp.activity.OrderDetailsActivity;
import com.jamshidbek.shoppingapp.databinding.ActivitySplashPageBinding;

public class SplashPage extends BaseActivity<ActivitySplashPageBinding> {

    @Override
    protected ActivitySplashPageBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivitySplashPageBinding.inflate(inflater);
    }

    @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            boolean isLoggedIn = (boolean) preferenceManager.getValue(Boolean.class, "isLoggedIn", false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (isLoggedIn){

                        Intent intent = new Intent(SplashPage.this, MainActivity.class);
                        startActivity(intent);
                    }else {
                        Intent intent = new Intent(SplashPage.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            }, 2000);
        }
}