package com.india.cpgram.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DepartmentModel {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("orgcode")
        @Expose
        private String orgcode;
        @SerializedName("parent")
        @Expose
        private String parent;
        @SerializedName("stage")
        @Expose
        private String stage;
        @SerializedName("monitoringcode")
        @Expose
        private String monitoringcode;
        @SerializedName("field_details")
        @Expose
        private List<GrievanceFieldSearch> fieldDetails;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrgcode() {
            return orgcode;
        }

        public void setOrgcode(String orgcode) {
            this.orgcode = orgcode;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getStage() {
            return stage;
        }

        public void setStage(String stage) {
            this.stage = stage;
        }

        public String getMonitoringcode() {
            return monitoringcode;
        }

        public void setMonitoringcode(String monitoringcode) {
            this.monitoringcode = monitoringcode;
        }

        public List<GrievanceFieldSearch> getFieldDetails() {
            return fieldDetails;
        }

        public void setFieldDetails(List<GrievanceFieldSearch> fieldDetails) {
            this.fieldDetails = fieldDetails;
        }


}

