package com.india.cpgram.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GrievanceSaveResponse {


        @SerializedName("success")
        @Expose
        private Boolean success;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("response")
        @Expose
        private Response response;

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

        public Response getResponse() {
            return response;
        }

        public void setResponse(Response response) {
            this.response = response;
        }

    public class GrievaneData {

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
        private String assignTo;
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
        private Object field2;
        @SerializedName("field_3")
        @Expose
        private Object field3;
        @SerializedName("field_4")
        @Expose
        private Object field4;
        @SerializedName("field_5")
        @Expose
        private Object field5;
        @SerializedName("field_6")
        @Expose
        private Object field6;
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
        @SerializedName("feedback_description")
        @Expose
        private Object feedbackDescription;
        @SerializedName("feedback_rating")
        @Expose
        private Object feedbackRating;
        @SerializedName("sla")
        @Expose
        private Object sla;
        @SerializedName("is_appeal")
        @Expose
        private Object isAppeal;
        @SerializedName("appeal_description")
        @Expose
        private Object appealDescription;
        @SerializedName("channel")
        @Expose
        private Object channel;

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

        public String getAssignTo() {
            return assignTo;
        }

        public void setAssignTo(String assignTo) {
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

        public Object getField2() {
            return field2;
        }

        public void setField2(Object field2) {
            this.field2 = field2;
        }

        public Object getField3() {
            return field3;
        }

        public void setField3(Object field3) {
            this.field3 = field3;
        }

        public Object getField4() {
            return field4;
        }

        public void setField4(Object field4) {
            this.field4 = field4;
        }

        public Object getField5() {
            return field5;
        }

        public void setField5(Object field5) {
            this.field5 = field5;
        }

        public Object getField6() {
            return field6;
        }

        public void setField6(Object field6) {
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

        public Object getFeedbackDescription() {
            return feedbackDescription;
        }

        public void setFeedbackDescription(Object feedbackDescription) {
            this.feedbackDescription = feedbackDescription;
        }

        public Object getFeedbackRating() {
            return feedbackRating;
        }

        public void setFeedbackRating(Object feedbackRating) {
            this.feedbackRating = feedbackRating;
        }

        public Object getSla() {
            return sla;
        }

        public void setSla(Object sla) {
            this.sla = sla;
        }

        public Object getIsAppeal() {
            return isAppeal;
        }

        public void setIsAppeal(Object isAppeal) {
            this.isAppeal = isAppeal;
        }

        public Object getAppealDescription() {
            return appealDescription;
        }

        public void setAppealDescription(Object appealDescription) {
            this.appealDescription = appealDescription;
        }

        public Object getChannel() {
            return channel;
        }

        public void setChannel(Object channel) {
            this.channel = channel;
        }

    }

    public class NotificationRes {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("is_seen")
        @Expose
        private Boolean isSeen;
        @SerializedName("grievance_id")
        @Expose
        private String grievanceId;
        @SerializedName("created_time")
        @Expose
        private String createdTime;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Boolean getIsSeen() {
            return isSeen;
        }

        public void setIsSeen(Boolean isSeen) {
            this.isSeen = isSeen;
        }

        public String getGrievanceId() {
            return grievanceId;
        }

        public void setGrievanceId(String grievanceId) {
            this.grievanceId = grievanceId;
        }

        public String getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(String createdTime) {
            this.createdTime = createdTime;
        }

    }

    public class Response {

        @SerializedName("grievaneData")
        @Expose
        private GrievaneData grievaneData;
        @SerializedName("workflowData")
        @Expose
        private WorkFlowDetail workflowData;
        @SerializedName("notificationRes")
        @Expose
        private NotificationRes notificationRes;

        public GrievaneData getGrievaneData() {
            return grievaneData;
        }

        public void setGrievaneData(GrievaneData grievaneData) {
            this.grievaneData = grievaneData;
        }

        public WorkFlowDetail getWorkflowData() {
            return workflowData;
        }

        public void setWorkflowData(WorkFlowDetail workflowData) {
            this.workflowData = workflowData;
        }

        public NotificationRes getNotificationRes() {
            return notificationRes;
        }

        public void setNotificationRes(NotificationRes notificationRes) {
            this.notificationRes = notificationRes;
        }

    }

}
