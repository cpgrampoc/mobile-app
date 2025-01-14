package com.india.cpgram.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.india.cpgram.model.response.GrievanceField;

import java.util.List;

public class GrievanceDataRequest {

        public  GrievanceDataRequest(){
        }

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("district")
        @Expose
        private String district;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("address2")
        @Expose
        private Object address2;
        @SerializedName("pinCode")
        @Expose
        private String pinCode;
        @SerializedName("emailId")
        @Expose
        private String emailId;
        @SerializedName("mobileNo")
        @Expose
        private String mobileNo;
        @SerializedName("field_details")
        @Expose
        private List<GrievanceField> fieldDetails;
        @SerializedName("raised_by")
        @Expose
        private Integer raisedBy;
        @SerializedName("description_en")
        @Expose
        private String descriptionEn;
        @SerializedName("description_other")
        @Expose
        private String descriptionOther;
        @SerializedName("assign_by")
        @Expose
        private Integer assignBy;
        @SerializedName("assign_to")
        @Expose
        private String assignTo;
        @SerializedName("deptid")
        @Expose
        private Integer deptid;
        @SerializedName("channel")
        @Expose
        private String channel;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Object getAddress2() {
            return address2;
        }

        public void setAddress2(Object address2) {
            this.address2 = address2;
        }

        public String getPinCode() {
            return pinCode;
        }

        public void setPinCode(String pinCode) {
            this.pinCode = pinCode;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public List<GrievanceField> getFieldDetails() {
            return fieldDetails;
        }

        public void setFieldDetails(List<GrievanceField> fieldDetails) {
            this.fieldDetails = fieldDetails;
        }

        public Integer getRaisedBy() {
            return raisedBy;
        }

        public void setRaisedBy(Integer raisedBy) {
            this.raisedBy = raisedBy;
        }

        public String getDescriptionEn() {
            return descriptionEn;
        }

        public void setDescriptionEn(String descriptionEn) {
            this.descriptionEn = descriptionEn;
        }

        public String getDescriptionOther() {
            return descriptionOther;
        }

        public void setDescriptionOther(String descriptionOther) {
            this.descriptionOther = descriptionOther;
        }

        public Integer getAssignBy() {
            return assignBy;
        }

        public void setAssignBy(Integer assignBy) {
            this.assignBy = assignBy;
        }

        public String getAssignTo() {
            return assignTo;
        }

        public void setAssignTo(String assignTo) {
            this.assignTo = assignTo;
        }

        public Integer getDeptid() {
            return deptid;
        }

        public void setDeptid(Integer deptid) {
            this.deptid = deptid;
        }

        public String getChannel() {
            return channel;
        }

        public void setChannel(String channel) {
            this.channel = channel;
        }
}
