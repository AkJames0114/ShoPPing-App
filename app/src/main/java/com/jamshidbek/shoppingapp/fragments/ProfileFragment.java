package com.jamshidbek.shoppingapp.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.jamshidbek.shoppingapp.Base.BaseFragment;
import com.jamshidbek.shoppingapp.databinding.FragmentProfileBinding;

public class ProfileFragment extends BaseFragment<FragmentProfileBinding> {
    @Override
    protected FragmentProfileBinding inflateView(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentProfileBinding.inflate(inflater, parent, toAttach);
    }
}
