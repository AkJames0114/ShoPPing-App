package com.jamshidbek.shoppingapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.jamshidbek.shoppingapp.Base.BaseAdapter;
import com.jamshidbek.shoppingapp.Base.BaseViewHolder;
import com.jamshidbek.shoppingapp.Model.ColorOption;
import com.jamshidbek.shoppingapp.Model.SizeOption;
import com.jamshidbek.shoppingapp.R;
import com.jamshidbek.shoppingapp.databinding.ItemOptionBinding;
import com.jamshidbek.shoppingapp.fragments.OptionDialog;

import java.util.ArrayList;

public class OptionListAdapter extends BaseAdapter {


    private ArrayList<ColorOption> colorOptionArrayList;
    private ArrayList<SizeOption> sizeOptionArrayList;

    private OptionDialog.OptionItemListener optionItemListener;

    public void setOptionItemListener(OptionDialog.OptionItemListener optionItemListener) {
        this.optionItemListener = optionItemListener;
    }

    public OptionListAdapter(ArrayList<ColorOption> colorOptionArrayList, ArrayList<SizeOption> sizeOptionArrayList) {
        this.colorOptionArrayList = colorOptionArrayList;
        this.sizeOptionArrayList = sizeOptionArrayList;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOptionBinding binding = ItemOptionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new OptionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);

        holder.itemView.findViewById(R.id.tvOptionTitle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (optionItemListener != null) {
                    if (colorOptionArrayList != null && sizeOptionArrayList == null)
                        optionItemListener.onColorItemSelected(colorOptionArrayList.get(position));
                    else if (colorOptionArrayList == null && sizeOptionArrayList != null)
                        optionItemListener.onSizeItemSelected(sizeOptionArrayList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (colorOptionArrayList != null && sizeOptionArrayList == null)
            return colorOptionArrayList.size();
        else if (colorOptionArrayList == null && sizeOptionArrayList != null)
            return sizeOptionArrayList.size();
        else
            return 0;
    }

    public class OptionViewHolder extends BaseViewHolder<ItemOptionBinding> {
        public OptionViewHolder(ItemOptionBinding binding) {
            super(binding);
        }

        @Override
        public void onBind(int position) {
            if (colorOptionArrayList != null && sizeOptionArrayList == null) {
                ColorOption colorOption = colorOptionArrayList.get(position);
                binding.tvOptionTitle.setText(colorOption.getTitle());
            } else if (colorOptionArrayList == null && sizeOptionArrayList != null) {
                SizeOption sizeOption = sizeOptionArrayList.get(position);
                binding.tvOptionTitle.setText(sizeOption.getTitle());
            }


        }
    }
}
