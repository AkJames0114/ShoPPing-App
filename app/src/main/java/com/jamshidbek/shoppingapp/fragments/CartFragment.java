package com.jamshidbek.shoppingapp.fragments;

import android.view.LayoutInflater;
import android.view.ViewGroup;


import com.jamshidbek.shoppingapp.Base.BaseFragment;
import com.jamshidbek.shoppingapp.databinding.FragmentCartBinding;

/*
    TODO LIST
    1. Add RecyclerView to fragment_cart.xml
    2. Create CartListAdapter
        1.Create item_cart.xml
        2.Create cart array list
        3.Create CartViewHolder
        4.Bind()
    3. Create Cart Model
    4. Add method to Main Api

    Inside Cart Fragment:
    5. onCreate()
        initialize cartArrayList and cartListAdapter
    6. onViewCreated()
        set LayoutManager to RecyclerView.
        set adapter to RecyclerView
    7. loadCarts()
        add carts to cartArrayList
        adapter.notifyDataSetChanged();

 */

public class CartFragment extends BaseFragment<FragmentCartBinding> {
    @Override
    protected FragmentCartBinding inflateView(LayoutInflater inflater, ViewGroup parent, boolean toAttach) {
        return FragmentCartBinding.inflate(inflater, parent, toAttach);
    }
}
