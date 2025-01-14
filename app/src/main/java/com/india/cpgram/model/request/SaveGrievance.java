package com.india.cpgram.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.india.cpgram.model.response.GrievanceField;

import java.util.List;

public class SaveGrievance {

    public SaveGrievance(){

    }


        @SerializedName("data")
        @Expose
        private GrievanceDataRequest data;

        public GrievanceDataRequest getData() {
            return data;
        }

        public void setData(GrievanceDataRequest data) {
            this.data = data;
        }

}
