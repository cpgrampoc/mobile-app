package com.india.cpgram.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkFlowDetail {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("comments")
        @Expose
        private String comments;
        @SerializedName("assign_by")
        @Expose
        private String assignBy;
        @SerializedName("assign_to")
        @Expose
        private Object assignTo;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created_date")
        @Expose
        private String createdDate;
        @SerializedName("grievance_id")
        @Expose
        private String grievanceId;
        @SerializedName("action")
        @Expose
        private String action;
        @SerializedName("employee_name")
        @Expose
        private Object employeeName;
        @SerializedName("employee_type")
        @Expose
        private Object employeeType;
        @SerializedName("employee_email")
        @Expose
        private Object employeeEmail;
        @SerializedName("employee_mobile_no")
        @Expose
        private Object employeeMobileNo;
        @SerializedName("assign_by_employee_name")
        @Expose
        private String assignByEmployeeName;
        @SerializedName("assign_by_employee_type")
        @Expose
        private String assignByEmployeeType;
        @SerializedName("assign_by_employee_email")
        @Expose
        private String assignByEmployeeEmail;
        @SerializedName("assign_by_employee_mobile_no")
        @Expose
        private String assignByEmployeeMobileNo;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
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

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public String getGrievanceId() {
            return grievanceId;
        }

        public void setGrievanceId(String grievanceId) {
            this.grievanceId = grievanceId;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public Object getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(Object employeeName) {
            this.employeeName = employeeName;
        }

        public Object getEmployeeType() {
            return employeeType;
        }

        public void setEmployeeType(Object employeeType) {
            this.employeeType = employeeType;
        }

        public Object getEmployeeEmail() {
            return employeeEmail;
        }

        public void setEmployeeEmail(Object employeeEmail) {
            this.employeeEmail = employeeEmail;
        }

        public Object getEmployeeMobileNo() {
            return employeeMobileNo;
        }

        public void setEmployeeMobileNo(Object employeeMobileNo) {
            this.employeeMobileNo = employeeMobileNo;
        }

        public String getAssignByEmployeeName() {
            return assignByEmployeeName;
        }

        public void setAssignByEmployeeName(String assignByEmployeeName) {
            this.assignByEmployeeName = assignByEmployeeName;
        }

        public String getAssignByEmployeeType() {
            return assignByEmployeeType;
        }

        public void setAssignByEmployeeType(String assignByEmployeeType) {
            this.assignByEmployeeType = assignByEmployeeType;
        }

        public String getAssignByEmployeeEmail() {
            return assignByEmployeeEmail;
        }

        public void setAssignByEmployeeEmail(String assignByEmployeeEmail) {
            this.assignByEmployeeEmail = assignByEmployeeEmail;
        }

        public String getAssignByEmployeeMobileNo() {
            return assignByEmployeeMobileNo;
        }

        public void setAssignByEmployeeMobileNo(String assignByEmployeeMobileNo) {
            this.assignByEmployeeMobileNo = assignByEmployeeMobileNo;
        }

    }

