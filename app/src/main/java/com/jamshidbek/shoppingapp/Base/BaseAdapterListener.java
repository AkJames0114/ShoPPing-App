package com.jamshidbek.shoppingapp.Base;

import com.jamshidbek.shoppingapp.adapter.ClassificationAdapter;

public interface BaseAdapterListener {

    void onCategoryClick(int id, String title, ClassificationAdapter.Type type);
}
