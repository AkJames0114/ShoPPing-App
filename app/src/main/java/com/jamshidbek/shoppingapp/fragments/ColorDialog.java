package com.jamshidbek.shoppingapp.fragments;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jamshidbek.shoppingapp.Base.BaseDialog;
import com.jamshidbek.shoppingapp.databinding.DialogColorBinding;

public class ColorDialog extends BaseDialog<DialogColorBinding> {
    @Override
    protected DialogColorBinding inflateView(LayoutInflater inflater, ViewGroup parent, boolean attachedToRoot) {
        return DialogColorBinding.inflate(inflater, parent, attachedToRoot) ;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

//        RelativeLayout root = new RelativeLayout(getActivity());
//        root.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//
//
//        Dialog dialog = new Dialog(getContext());
//
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(root);
//
//        if (dialog.getWindow() != null){
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        }
//        dialog.setCanceledOnTouchOutside(false);

        return super.onCreateDialog(savedInstanceState);
    }

}
