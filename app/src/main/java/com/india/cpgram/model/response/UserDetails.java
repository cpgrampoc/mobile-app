package com.india.cpgram.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.ObjectStreamClass;

public class UserDetails {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private String  address;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("userType")
    @Expose
    private String userType;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("created_by")
    @Expose
    private String createdBy;
    @SerializedName("updated_by")
    @Expose
    private String updatedBy;
    @SerializedName("createdOn")
    @Expose
    private String createdOn;
    @SerializedName("updatedOn")
    @Expose
    private String updatedOn;
    @SerializedName("organization")
    @Expose
    private String organization;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String  createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String  updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Object getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Object getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String  updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Object getOrganization() {
        return organization;
    }

    public void setOrganization(String  organization) {
        this.organization = organization;
    }
}
