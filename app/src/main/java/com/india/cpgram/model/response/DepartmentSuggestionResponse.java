package com.india.cpgram.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DepartmentSuggestionResponse {

        @SerializedName("stage_3_details")
        @Expose
        private Stage3Details stage3Details;
        @SerializedName("stage_2_details")
        @Expose
        private List<Stage2Detail> stage2Details;
        @SerializedName("stage_1_details")
        @Expose
        private List<Stage1Detail> stage1Details;

        private  boolean clicked;

        public boolean isClicked() {
            return clicked;
        }

        public void setClicked(boolean clicked) {
            this.clicked = clicked;
        }

    public Stage3Details getStage3Details() {
            return stage3Details;
        }

        public void setStage3Details(Stage3Details stage3Details) {
            this.stage3Details = stage3Details;
        }

        public List<Stage2Detail> getStage2Details() {
            return stage2Details;
        }

        public void setStage2Details(List<Stage2Detail> stage2Details) {
            this.stage2Details = stage2Details;
        }

        public List<Stage1Detail> getStage1Details() {
            return stage1Details;
        }

        public void setStage1Details(List<Stage1Detail> stage1Details) {
            this.stage1Details = stage1Details;
        }


    public class Stage1Detail {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("code")
        @Expose
        private Object code;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("parent")
        @Expose
        private String parent;
        @SerializedName("stage")
        @Expose
        private String stage;
        @SerializedName("field_details")
        @Expose
        private Object fieldDetails;
        @SerializedName("monitoringcode")
        @Expose
        private String monitoringcode;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public Object getFieldDetails() {
            return fieldDetails;
        }

        public void setFieldDetails(Object fieldDetails) {
            this.fieldDetails = fieldDetails;
        }

        public String getMonitoringcode() {
            return monitoringcode;
        }

        public void setMonitoringcode(String monitoringcode) {
            this.monitoringcode = monitoringcode;
        }

    }

    public class Stage2Detail {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("code")
        @Expose
        private Object code;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("parent")
        @Expose
        private String parent;
        @SerializedName("stage")
        @Expose
        private String stage;
        @SerializedName("field_details")
        @Expose
        private Object fieldDetails;
        @SerializedName("monitoringcode")
        @Expose
        private String monitoringcode;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public Object getFieldDetails() {
            return fieldDetails;
        }

        public void setFieldDetails(Object fieldDetails) {
            this.fieldDetails = fieldDetails;
        }

        public String getMonitoringcode() {
            return monitoringcode;
        }

        public void setMonitoringcode(String monitoringcode) {
            this.monitoringcode = monitoringcode;
        }

    }

    public class Stage3Details {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("code")
        @Expose
        private Object code;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("parent")
        @Expose
        private String parent;
        @SerializedName("stage")
        @Expose
        private String stage;
        @SerializedName("field_details")
        @Expose
        private List<GrievanceFieldSearch> fieldDetails;
        @SerializedName("monitoringcode")
        @Expose
        private String monitoringcode;
        @SerializedName("rank")
        @Expose
        private Double rank;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Object getCode() {
            return code;
        }

        public void setCode(Object code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
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

        public List<GrievanceFieldSearch> getFieldDetails() {
            return fieldDetails;
        }

        public void setFieldDetails(List<GrievanceFieldSearch> fieldDetails) {
            this.fieldDetails = fieldDetails;
        }

        public String getMonitoringcode() {
            return monitoringcode;
        }

        public void setMonitoringcode(String monitoringcode) {
            this.monitoringcode = monitoringcode;
        }

        public Double getRank() {
            return rank;
        }

        public void setRank(Double rank) {
            this.rank = rank;
        }

    }

}
