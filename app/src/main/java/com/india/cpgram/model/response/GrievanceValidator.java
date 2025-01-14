package com.india.cpgram.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrievanceValidator {
    public  GrievanceValidator( Boolean required){
        this.required = required;
    }
    @SerializedName("required")
    @Expose
    private Boolean required;

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

}


