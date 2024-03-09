package com.jamshidbek.shoppingapp.activity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.jamshidbek.shoppingapp.AddressActivity;
import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.Base.RequestCallback;
import com.jamshidbek.shoppingapp.MainActivity;
import com.jamshidbek.shoppingapp.Model.User;
import com.jamshidbek.shoppingapp.databinding.ActivityMyAddressBinding;

import retrofit2.Call;
import retrofit2.Response;

public class MyAddressActivity extends BaseActivity<ActivityMyAddressBinding> {

    @Override
    protected ActivityMyAddressBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityMyAddressBinding.inflate(inflater);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        String postCode = (String) preferenceManager.getValue(String.class, "postcode", "Default text");
//        binding.tvpostCode.setText(postCode);
//        String tvAddress = (String) preferenceManager.getValue(String.class, "tvAddress", "Default text");
//        binding.tvAddress.setText(tvAddress);
//        String etAddressDetails = (String) preferenceManager.getValue(String.class, "etAddressDetails", "Default text");
//        binding.etAddressDetatils.setText(etAddressDetails);

        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String address = binding.tvAddress.getText().toString();
//                String addressDetails1 = binding.etAddressDetatils.getText().toString();
//                String postCode = binding.tvpostCode.getText().toString();


                Intent intent = new Intent(MyAddressActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        binding.btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyAddressActivity.this, AddressActivity.class);
                activityResultLauncher.launch(intent);
            }
        });
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        String postcode = data.getStringExtra("postcode");
                        String address = data.getStringExtra("address");
                        binding.tvpostCode.setText(postcode);
                        binding.tvAddress.setText(address);
                    }
                }
            }
    );
    private void createUser(User user){
        Call<User> call=mainApi.createUser(user);

        call.enqueue(new RequestCallback<User>() {
            @Override
            protected void onResponseSuccess(Call<User> call, Response<User> response) {
                onBind(response.body());
            }

            @Override
            protected void onResponseFailed(Call<User> call, Throwable t) {

            }
        });
    }
    private void onBind(User user){
        binding.tvAddress.setText(user.getTvAddress());
        binding.tvpostCode.setText(user.getPostCode());
        binding.etAddressDetatils.setText(user.getEtAddressDetails());
    }
}