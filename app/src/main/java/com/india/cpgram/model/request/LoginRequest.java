package com.india.cpgram.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


    public class LoginRequest {

        @SerializedName("userType")
        @Expose
        private String userType;
        @SerializedName("mobileNo")
        @Expose
        private String mobileNo;
        @SerializedName("password")
        @Expose
        private String password;

        public LoginRequest(String userType,String mobileNo,String password){
            this.password=password;
            this.mobileNo=mobileNo;
            this.userType=userType;
        }
        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
