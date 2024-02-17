package com.jamshidbek.shoppingapp.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private Integer id;

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("first_name")
    private String first_name;

    @SerializedName("last_name")
    private String last_name;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("address")
    private String address;
    @SerializedName("img")
    private String img;

    @SerializedName("device_token")
    private String deviceToken;

    @SerializedName("access_token")
    private String accessToken;





    public User(Integer id, String email, String password, String first_name, String img, String last_name, String phoneNumber, String address, String deviceToken, String accessToken) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.img = img;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.deviceToken = deviceToken;
        this.accessToken = accessToken;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public User() {

    }

    public User(String email, String password, String firstname, String lastname, String phoneNumber, String address) {

        this.email = email;
        this.password = password;
        this.first_name = firstname;
        this.last_name = lastname;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
