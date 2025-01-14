package com.india.cpgram.model;

public class GrievanceModel {
        private int grievanceNo;
        private String category;
        private String description;
        private String status;
        private String date;

        // Constructor
        public GrievanceModel(int grievanceNo, String category, String description, String status, String date) {
            this.grievanceNo = grievanceNo;
            this.category = category;
            this.description = description;
            this.status = status;
            this.date = date;
        }

        // Getters and Setters
        public int getGrievanceNo() {
            return grievanceNo;
        }

        public void setGrievanceNo(int grievanceNo) {
            this.grievanceNo = grievanceNo;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Grievance{" +
                    "grievanceNo=" + grievanceNo +
                    ", category='" + category + '\'' +
                    ", description='" + description + '\'' +
                    ", status='" + status + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
    }


