package com.example.smarttutor.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class TutorResponse {

        @SerializedName("name")
        @Expose
        String name;
        @SerializedName("phone")
        @Expose
        String phone;
        @SerializedName("subjects")
        @Expose
        String subjects;
        @SerializedName("rating")
        @Expose
        Double rating;
        @SerializedName("imageUrl")
        @Expose
        String imageUrl;
        @SerializedName("experience")
        @Expose
        String experience;
        @SerializedName("bio")
        @Expose
        String bio;
        @SerializedName("id")
        @Expose
        Integer id;

        /**
         * No args constructor for use in serialization
         */
        public TutorResponse() {
        }

        /**
         * @param experience
         *  @param subjects
         * @param bio
         * @param phone
         * @param imageUrl
         * @param name
         * @param rating
         * @param
         */
        public TutorResponse(String experience, String subjects, String name, String phone, double rating, String imageUrl, String bio) {
            this.experience = experience;
            this.subjects = subjects;
            this.name = name;
            this.phone = phone;
            this.rating = rating;
            this.imageUrl = imageUrl;
            imageUrl = getLargeImageUrl(imageUrl);
            this.bio = bio;
        }
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public String getLargeImageUrl(String imageUrl) {
        String largeImageUrl = imageUrl.substring(0, imageUrl.length() - 6).concat("o.jpg");
        return largeImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
