package com.india.cpgram.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrievanceDetailsRequest {




    public class GrievanceM {
        public GrievanceM(String grievanceId){
            this.grievanceId= grievanceId;
        }
        @SerializedName("grievanceId")
        @Expose
        private String grievanceId;

        public String getUserId() {
            return grievanceId;
        }

        public void setUserId(String grievanceId) {
            this.grievanceId = grievanceId;
        }

    }


        @SerializedName("data")
        @Expose
        private GrievanceM grievanceM;

        public GrievanceM getData() {
            return grievanceM;
        }

        public void setData(GrievanceM grievanceM) {
            this.grievanceM = grievanceM;
        }

    public GrievanceDetailsRequest(String  grievanceId){
        this.grievanceM= new GrievanceM(grievanceId);
    }

}
