package com.jamshidbek.shoppingapp.Base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

public abstract class BaseActivity<T extends ViewBinding> extends AppCompatActivity {

    protected T binding;



    protected abstract T inflateViewBinding(LayoutInflater inflater);
    public MainApi mainApi;
    public PreferenceManager preferenceManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Xar bir activity uchun T toifadagi ViewBinding qaytaradi.
        binding = inflateViewBinding(getLayoutInflater());
        setContentView(binding.getRoot());
        mainApi = ApiService.provideApi(MainApi.class, this);
        /////Preference Manager ----------------------------------->
        preferenceManager = PreferenceManager.getInstance(this);

    }

}
