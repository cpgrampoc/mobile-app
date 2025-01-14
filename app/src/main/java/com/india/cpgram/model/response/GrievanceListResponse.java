package com.india.cpgram.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GrievanceListResponse {

        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("response")
        @Expose
        private List<GrievanceResponse> response;

        public Boolean getSuccess() {
            return success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public List<GrievanceResponse> getResponse() {
            return response;
        }

        public void setResponse(List<GrievanceResponse> response) {
            this.response = response;
        }








}
