package com.india.cpgram.model.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DepartmentSuggestionRequest {

   public DepartmentSuggestionRequest(String query){
       this.query=query;
   }

        @SerializedName("query")
        @Expose
        private String query;


        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }



}
