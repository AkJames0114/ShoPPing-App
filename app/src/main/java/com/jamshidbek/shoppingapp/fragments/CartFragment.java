package com.jamshidbek.shoppingapp.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.jamshidbek.shoppingapp.Base.BaseFragment;
import com.jamshidbek.shoppingapp.databinding.FragmentCartBinding;

public class CartFragment extends BaseFragment<FragmentCartBinding> {
    @Override
    protected FragmentCartBinding inflateView(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentCartBinding.inflate(inflater, parent, toAttach);
    }
}
