package com.jamshidbek.shoppingapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CartRequest implements Serializable {

    @SerializedName("product")
    private int product;
    @SerializedName("option")
    private int option;

    @SerializedName("quantity")
    private int quantity;

    public CartRequest(int product, int option, int quantity) {
        this.product = product;
        this.option = option;
        this.quantity = quantity;
    }

    public int getProduct() {
        return product;
    }

    public void setProduct(int product) {
        this.product = product;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
