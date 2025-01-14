package com.india.cpgram.model.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class ErrorResponse {

        @SerializedName("StatusCode")
        @Expose
        private Integer statusCode;
        @SerializedName("errors")
        @Expose
        private String errors;
        @SerializedName("Data")
        @Expose
        private Object data;

        public Integer getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(Integer statusCode) {
            this.statusCode = statusCode;
        }

        public String getErrors() {
            return errors;
        }

        public void setErrors(String errors) {
            this.errors = errors;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

    }

