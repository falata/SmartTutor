package com.example.smarttutor.models;

import org.parceler.Parcel;

@Parcel
public class Tutor {
    String experience;
    String subjects;
    String name;
    String phone;
    double rating;
    String imageUrl;
    String bio;
    public Tutor () {}
    public Tutor(String experience, String subjects, String name, String phone, double rating, String imageUrl, String bio) {
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

}
