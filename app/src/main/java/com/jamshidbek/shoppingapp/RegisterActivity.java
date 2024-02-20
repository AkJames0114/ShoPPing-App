package com.jamshidbek.shoppingapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.Model.User;
import com.jamshidbek.shoppingapp.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        /*When click agreement */
        binding.agreementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected = binding.agreementBtn.isSelected();
                binding.agreementBtn.setSelected(!isSelected);
            }
        });

        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = binding.firstNameET.getText().toString();
                String lastname = binding.lastNameET.getText().toString();
                String email = binding.emailEditText.getText().toString();
                String password = binding.passwordEditText.getText().toString();
                String confirmPassword = binding.confirmPassEditText.getText().toString();
                String phoneNumber = binding.phoneNumEditText.getText().toString();
                String address = binding.tvAddress.getText().toString();
                String addressDetails1 = binding.etAddressDetatils.getText().toString();
                String postCode = binding.tvpostCode.getText().toString();
                //checking input is empty
                if (!isEmailValid(email)) {
                    binding.emailEditText.setError("Email is not valid");
                    return;
                }

                if (firstname.isEmpty()) {
                    binding.firstNameET.setError("Required");
                    return;
                }

                if (lastname.isEmpty()) {
                    binding.lastNameET.setError("Required");
                    return;
                }

                if (password.isEmpty()) {
                    binding.passwordEditText.setError("Required");
                    return;
                }
                if (confirmPassword.isEmpty()) {
                    binding.confirmPassEditText.setError("Required");
                    return;
                }
                if (!password.equals(confirmPassword)) {
                    binding.confirmPassEditText.setError("Passwords should be the same");
                    return;
                }

                if (postCode.isEmpty() || address.isEmpty()) {
                    binding.tvpostCode.setError("Required");
                    binding.tvAddress.setError("Required");
                    return;
                }

                if (addressDetails1.isEmpty()) {
                    binding.etAddressDetatils.setError("Required");
                    return;
                }

                String full_address = "[" + postCode + "] " + address + ", " + addressDetails1;
                User user = new User(email, password, firstname, lastname, phoneNumber, full_address);
                        Log.d("User", new Gson().toJson(user));

                        Call<User> call = mainApi.createUser(user);
                        call.enqueue(new Callback<User>() {
                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                if (response.isSuccessful()) {
                                    User newUser = response.body();
                                    preferenceManager.setValue("isLoggedIn", true);
                                    preferenceManager.setValue("access_token", newUser.getAccessToken());
                                    preferenceManager.setValue("id", newUser.getId());
                                    preferenceManager.setValue("firstname", newUser.getFirst_name());
                                    preferenceManager.setValue("lastname", newUser.getLast_name());
                                    preferenceManager.setValue("email", newUser.getEmail());
                                    preferenceManager.setValue("password", password);
                                    preferenceManager.setValue("phoneNumber", newUser.getPhoneNumber());
                                    preferenceManager.setValue("address", newUser.getAddress());
                                    moveToMain();
                                   // preferenceManager.setValue("refresh_token", newUser.getReresh_token());

                                    CharSequence text = "Registration is completed";
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(RegisterActivity.this, text, duration);
                                    toast.show();

                                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                    startActivity(intent);

                                }else {
                                    Log.d("User", "Error receiving response from API");
                                }
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                            }
                        });
                    //passwordError set VISIBLE
                    //signupError set VISIBLE
            }
        });
        binding.btnAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, AddressActivity.class);
                activityResultLauncher.launch(intent);
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

    private void moveToMain() {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
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