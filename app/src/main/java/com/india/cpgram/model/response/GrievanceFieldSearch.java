package com.india.cpgram.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GrievanceFieldSearch {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("field_name")
        @Expose
        private String fieldName;
        @SerializedName("field_type")
        @Expose
        private FieldType fieldType;
        @SerializedName("model_name")
        @Expose
        private String modelName;
        @SerializedName("is_mandetory")
        @Expose
        private Boolean isMandetory;
        @SerializedName("dropdown_value")
        @Expose
        private List<String> dropdownValue;
        @SerializedName("dropdown_values")
        @Expose
        private List<Object> dropdownValues;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public FieldType getFieldType() {
            return fieldType;
        }

        public void setFieldType(FieldType fieldType) {
            this.fieldType = fieldType;
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName) {
            this.modelName = modelName;
        }

        public Boolean getIsMandetory() {
            return isMandetory;
        }

        public void setIsMandetory(Boolean isMandetory) {
            this.isMandetory = isMandetory;
        }

        public List<String> getDropdownValue() {
            return dropdownValue;
        }

        public void setDropdownValue(List<String> dropdownValue) {
            this.dropdownValue = dropdownValue;
        }

        public List<Object> getDropdownValues() {
            return dropdownValues;
        }

        public void setDropdownValues(List<Object> dropdownValues) {
            this.dropdownValues = dropdownValues;
        }

    public class FieldType {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("name")
        @Expose
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}

