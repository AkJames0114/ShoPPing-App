package com.jamshidbek.shoppingapp.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Subproduct implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;
    @SerializedName("is_active")
    private Boolean isActive;

    public Subproduct() {
    }

    public Subproduct(int id, String title, Boolean isActive) {
        this.id = id;
        this.title = title;
        this.isActive = isActive;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
