package com.jamshidbek.shoppingapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jamshidbek.shoppingapp.Base.BaseFragment;
import com.jamshidbek.shoppingapp.LoginActivity;
import com.jamshidbek.shoppingapp.Model.Banner;
import com.jamshidbek.shoppingapp.Model.User;
import com.jamshidbek.shoppingapp.R;
import com.jamshidbek.shoppingapp.RegisterActivity;
import com.jamshidbek.shoppingapp.activity.MyAddressActivity;
import com.jamshidbek.shoppingapp.databinding.FragmentProfileBinding;

import java.io.File;

public class ProfileFragment extends BaseFragment<FragmentProfileBinding> {

    private User user;
    @Override
    protected FragmentProfileBinding inflateView(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentProfileBinding.inflate(inflater, parent, toAttach);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String firstname = (String) parent.preferenceManager.getValue(String.class, "firstname", "Default text");
        binding.firstnamePf.setText(firstname);
        String lastname = (String) parent.preferenceManager.getValue(String.class, "lastname", "Default text");
        binding.lastnamePf.setText(lastname);

        binding.logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.preferenceManager.setValue("isLogin", false);
                String filename = "my_access_token.txt";

                Log.d("ProfileFragment", getContext().getFilesDir() + "/" + filename);

                File file = new File(getContext().getFilesDir(), filename);
                if (file.delete()) {
                    Log.d("ProfileFragment ", "Token file is deleted");
                }

                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        binding.myAddressBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MyAddressActivity.class);
                startActivity(intent);
            }
        });

    }
//    @Override
//    public void onResume() {
//        super.onResume();
//
//            RequestOptions options = new RequestOptions();
//            options.centerCrop();
//
//        Glide.with(binding.getRoot()).load(user.getImg()).apply(options).placeholder(R.drawable.ic_user).into(binding.userPhoto);
//    }
}
