package com.india.cpgram.model;

public class CardModel {
        private String description;
        private String date;
        private int imgId;
        public CardModel(String description, int imgId,String  date) {
            this.description = description;
            this.imgId = imgId;
            this.date=date;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public int getImgId() {
            return imgId;
        }
        public void setImgId(int imgId) {
            this.imgId = imgId;
        }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
