package com.india.cpgram.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepartmentRequest {

    public class ParentM {
        public ParentM(Integer userId){
            this.parent= userId;
        }
        @SerializedName("parent")
        @Expose
        private Integer parent;

        public Integer getParent() {
            return parent;
        }

        public void setParent(Integer parent) {
            this.parent = parent;
        }

    }


    @SerializedName("data")
    @Expose
    private ParentM parentM;

    public ParentM getData() {
        return parentM;
    }

    public void setData(ParentM data) {
        this.parentM = parentM;
    }

    public DepartmentRequest(int parent){
        this.parentM= new ParentM(parent);
    }



}
