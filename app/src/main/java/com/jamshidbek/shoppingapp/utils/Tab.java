package com.jamshidbek.shoppingapp.utils;

public enum Tab {
    HOME("HOME"), PRODUCTS("PRODUCTS"), CART("CART"), PROFILE("PROFILE");

    private String tag;

    public String getTag() {
        return tag;
    }

    Tab(String tag) {
        this.tag = tag;
    }
}
