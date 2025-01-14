package com.india.cpgram.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GrievanceField {

        public  GrievanceField(){

        }
       public GrievanceField(String name,String type,String  label,String value,String placeholder ,GrievanceValidator validators){

           this.name = name;
           this.type = type;
           this.label = label;
           this.value = value;
           this.placeholder = placeholder;
           this.validators = validators;
       }

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("label")
        @Expose
        private String label;
        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("validators")
        @Expose
        private GrievanceValidator validators;
        @SerializedName("placeholder")
        @Expose
        private String placeholder;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public GrievanceValidator getValidators() {
            return validators;
        }

        public void setValidators(GrievanceValidator validators) {
            this.validators = validators;
        }

        public String getPlaceholder() {
            return placeholder;
        }

        public void setPlaceholder(String placeholder) {
            this.placeholder = placeholder;
        }

    }

