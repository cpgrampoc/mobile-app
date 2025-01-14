package com.india.cpgram.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrievanceListRequest {




    public class UserM {
        public UserM(Integer userId){
            this.userId= userId;
        }
        @SerializedName("userId")
        @Expose
        private Integer userId;

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

    }


        @SerializedName("data")
        @Expose
        private UserM userM;

        public UserM getData() {
            return userM;
        }

        public void setData(UserM data) {
            this.userM = data;
        }

    public GrievanceListRequest(int userId){
        this.userM= new UserM(userId);
    }

}
