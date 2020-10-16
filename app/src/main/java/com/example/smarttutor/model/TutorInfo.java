package com.example.smarttutor.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TutorInfo {
   @SerializedName("name")
   @Expose
    public String name;
    @SerializedName("experience")
    @Expose
    public String experience;
    @SerializedName("rating")
    @Expose
    public String rating;
    @SerializedName("phone")
    @Expose
    public String phone;
    @SerializedName("subjects")
    @Expose
    public String subjects;
    @SerializedName("bio")
    @Expose
    public String bio;
    @SerializedName("imageUrl")
    @Expose
    public String imageUrl;
    @SerializedName("id")
    @Expose
    public int id;


    public TutorInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TutorInfo{" +
                "name='" + name + '\'' +
                ", experience='" + experience + '\'' +
                ", rating='" + rating + '\'' +
                ", phone='" + phone + '\'' +
                ", subjects='" + subjects + '\'' +
                ", bio='" + bio + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", id=" + id +
                '}';
    }
}
