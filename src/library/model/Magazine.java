package library.model;

import java.io.Serializable;
import java.util.Objects;



    public class Magazine extends Publication {

        public static final String TYPE = "Magazine";

        private int month;
        private int day;
        private String language;

        public Magazine(String title, String publisher, String language, int year, int month, int day) {
            super(title, publisher, year);
            this.language = language;
            this.month = month;
            this.day = day;
        }

        public int getMonth() {
            return month;
        }
        public void setMonth(int month) {
            this.month = month;
        }
        public int getDay() {
            return day;
        }
        public void setDay(int day) {
            this.day = day;
        }
        public String getLanguage() {
            return language;
        }
        public void setLanguage(String language) {
            this.language = language;
        }


        @Override
        public String toCsv() {
            String srednik = ";";
            return (TYPE + srednik) +
                    getTitle() + srednik +
                    getPublisher() + srednik +
                    getYear() + srednik +
                    month + srednik +
                    day + srednik +
                    language + srednik;
        }

        @Override
        public String toString() {
            return super.toString() + ", " + month + ", " + day + ", " + language;
        }
    }
