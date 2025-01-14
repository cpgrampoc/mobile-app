package com.india.cpgram.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GrievanceResponse {
    

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("description_en")
        @Expose
        private String descriptionEn;
        @SerializedName("description_other")
        @Expose
        private String descriptionOther;
        @SerializedName("raised_by")
        @Expose
        private String raisedBy;
        @SerializedName("mobile_no")
        @Expose
        private String mobileNo;
        @SerializedName("assign_by")
        @Expose
        private String assignBy;
        @SerializedName("assign_to")
        @Expose
        private Object assignTo;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("grievance_id")
        @Expose
        private String grievanceId;
        @SerializedName("field_1")
        @Expose
        private List<GrievanceField> field1;
        @SerializedName("field_2")
        @Expose
        private List<GrievanceField> field2;
        @SerializedName("field_3")
        @Expose
        private List<GrievanceField> field3;
        @SerializedName("field_4")
        @Expose
        private List<GrievanceField> field4;
        @SerializedName("field_5")
        @Expose
        private List<GrievanceField> field5;
        @SerializedName("field_6")
        @Expose
        private List<GrievanceField> field6;
        @SerializedName("tracking_link")
        @Expose
        private String trackingLink;
        @SerializedName("deptid")
        @Expose
        private String deptid;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
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
        @SerializedName("address_2")
        @Expose
        private Object address2;
        @SerializedName("pincode")
        @Expose
        private String pincode;
        @SerializedName("gender")
        @Expose
        private Object gender;
        @SerializedName("email_id")
        @Expose
        private String emailId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("assign_to_details")
        @Expose
        private UserDetails assignToDetails;
        @SerializedName("workflowDetails")
        @Expose
        private List<WorkFlowDetail> workflowDetails;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getRaisedBy() {
            return raisedBy;
        }

        public void setRaisedBy(String raisedBy) {
            this.raisedBy = raisedBy;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getAssignBy() {
            return assignBy;
        }

        public void setAssignBy(String assignBy) {
            this.assignBy = assignBy;
        }

        public Object getAssignTo() {
            return assignTo;
        }

        public void setAssignTo(Object assignTo) {
            this.assignTo = assignTo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getGrievanceId() {
            return grievanceId;
        }

        public void setGrievanceId(String grievanceId) {
            this.grievanceId = grievanceId;
        }

        public List<GrievanceField> getField1() {
            return field1;
        }

        public void setField1(List<GrievanceField> field1) {
            this.field1 = field1;
        }

        public List<GrievanceField> getField2() {
            return field2;
        }

        public void setField2(List<GrievanceField> field2) {
            this.field2 = field2;
        }

        public List<GrievanceField> getField3() {
            return field3;
        }

        public void setField3(List<GrievanceField> field3) {
            this.field3 = field3;
        }

        public List<GrievanceField> getField4() {
            return field4;
        }

        public void setField4(List<GrievanceField> field4) {
            this.field4 = field4;
        }

        public List<GrievanceField> getField5() {
            return field5;
        }

        public void setField5(List<GrievanceField> field5) {
            this.field5 = field5;
        }

        public List<GrievanceField> getField6() {
            return field6;
        }

        public void setField6(List<GrievanceField> field6) {
            this.field6 = field6;
        }

        public String getTrackingLink() {
            return trackingLink;
        }

        public void setTrackingLink(String trackingLink) {
            this.trackingLink = trackingLink;
        }

        public String getDeptid() {
            return deptid;
        }

        public void setDeptid(String deptid) {
            this.deptid = deptid;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
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

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public UserDetails getAssignToDetails() {
            return assignToDetails;
        }

        public void setAssignToDetails(UserDetails assignToDetails) {
            this.assignToDetails = assignToDetails;
        }

        public List<WorkFlowDetail> getWorkflowDetails() {
            return workflowDetails;
        }

        public void setWorkflowDetails(List<WorkFlowDetail> workflowDetails) {
            this.workflowDetails = workflowDetails;
        }
}
