package com.jamshidbek.shoppingapp.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;


import com.jamshidbek.shoppingapp.Base.BaseActivity;
import com.jamshidbek.shoppingapp.Base.RequestCallback;
import com.jamshidbek.shoppingapp.Model.ColorOption;
import com.jamshidbek.shoppingapp.Model.Option;
import com.jamshidbek.shoppingapp.Model.Product;
import com.jamshidbek.shoppingapp.Model.ProductImage;
import com.jamshidbek.shoppingapp.Model.SizeOption;
import com.jamshidbek.shoppingapp.adapter.IndicatorAdapter;
import com.jamshidbek.shoppingapp.adapter.ProductImageViewPagerAdapter;
import com.jamshidbek.shoppingapp.databinding.ActivityProductDetailsBinding;
import com.jamshidbek.shoppingapp.fragments.OptionDialog;

import java.util.ArrayList;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Response;

public class ProductDetailsActivity extends BaseActivity<ActivityProductDetailsBinding> implements OptionDialog.OptionItemListener {

    private Product product;
    private ProductImageViewPagerAdapter viewPagerAdapter;
    private boolean isColorSelected = false;
    private boolean isSizeSelected = false;

    private final ArrayList<SizeOption> filteredSizeOptionArrayList = new ArrayList<>();

    private IndicatorAdapter indicatorAdapter;
    private final ArrayList<ProductImage> productImageArrayList = new ArrayList<>();

    @Override
    protected ActivityProductDetailsBinding inflateViewBinding(LayoutInflater inflater) {
        return ActivityProductDetailsBinding.inflate(inflater);
    }

    @Override
    protected boolean hasBackButton() {
        return true;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        product = (Product) getIntent().getSerializableExtra("product");
        if (product != null) {
            setTitle(product.getTitle());
            loadProductDetails();
        } else {
            finish();
        }

    }

    private void buildProductData() {
        productImageArrayList.addAll(product.getImages());
        viewPagerAdapter = new ProductImageViewPagerAdapter(ProductDetailsActivity.this, productImageArrayList);
        binding.productImageViewPager.setAdapter(viewPagerAdapter);
        indicatorAdapter = new IndicatorAdapter(productImageArrayList.size());
        binding.pagerIndicatorView.setLayoutManager(new LinearLayoutManager(ProductDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false));
        binding.pagerIndicatorView.setAdapter(indicatorAdapter);
        binding.productImageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                indicatorAdapter.setSelectedDotPosition(position);
                indicatorAdapter.notifyDataSetChanged();
            }
        });


        binding.productBrand.setText(product.getBrand());
        binding.productName.setText(product.getTitle());
        binding.productPriceCurrent.setText(product.getPriceCurrent());
        binding.productPriceOriginal.setText(product.getPriceOriginal());
        binding.productDetails.setText(product.getDescription());

        binding.tvColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OptionDialog optionDialog = new OptionDialog(); //Dialog created
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.addToBackStack(null);
                optionDialog.setColorOptionArrayList(product.getColorOptions()); //Before Dialog pop up, we giving it the color opt arraylist.
                optionDialog.setOptionItemListener(new OptionDialog.OptionItemListener() {
                    @Override
                    public void onColorItemSelected(ColorOption colorOption) {
                        isColorSelected = true;
                        filteredSizeOptionArrayList.clear();

                        product.getOptions().forEach(new Consumer<Option>() {
                            @Override
                            public void accept(Option option) {
                                if (option.getColorOption().equals(colorOption)){
                                    filteredSizeOptionArrayList.add(option.getSizeOption());
                                }
                            }
                        });
                    }

                    @Override
                    public void onSizeItemSelected(SizeOption sizeOption) {

                    }
                });
                optionDialog.show(ft, "dialog_color"); //Dialog pops up!

            }
        });
        binding.tvSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isColorSelected) {
                    OptionDialog optionDialog = new OptionDialog();
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.addToBackStack(null);
                    optionDialog.setSizeOptionArrayList(filteredSizeOptionArrayList);
                    optionDialog.setOptionItemListener(new OptionDialog.OptionItemListener() {
                        @Override
                        public void onColorItemSelected(ColorOption colorOption) {

                        }

                        @Override
                        public void onSizeItemSelected(SizeOption sizeOption) {
                            isSizeSelected = true;
                        }
                    });
                    optionDialog.show(ft, "dialog_size");
                }else {
                    Toast.makeText(ProductDetailsActivity.this, "Please select color first", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    private void loadProductDetails() {
        Call<Product> call = mainApi.getProductDetails(product.getId());

        call.enqueue(new RequestCallback<Product>() {
            @Override
            protected void onResponseSuccess(Call<Product> call, Response<Product> response) {
                product = response.body();
                buildProductData();
            }

            @Override
            protected void onResponseFailed(Call<Product> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, "Request is failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onColorItemSelected(ColorOption colorOption) {
        isColorSelected = true;
    }

    @Override
    public void onSizeItemSelected(SizeOption sizeOption) {
        isSizeSelected = true;
    }
}
