package com.jamshidbek.shoppingapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.R;
import com.jamshidbek.shoppingapp.databinding.ActivityOrderDetailsBinding;

/*
    1. Get Order data from intent ( getIntent().getSerializableExtra().
    2. Add order details (textview) to Order Details Page xml.
    3. Print Order details on textview. Order number, Order status etc
    4. Add RecyclerView
        1. Create List Adapter for ordered product list.
        2. Create ViewHolder for ordered products
        3. Set LayoutManger
        4. Set Adapter
*/
public class OrderDetailsActivity extends BaseActivity<ActivityOrderDetailsBinding> {
    @Override
    protected ActivityOrderDetailsBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityOrderDetailsBinding.inflate(inflater);
    }
}