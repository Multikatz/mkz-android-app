package com.multikatz.mkzandroidapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("BirthDate")
    @Expose
    private String birthDate;
    @SerializedName("Image")
    @Expose
    private String image;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Active")
    @Expose
    private Boolean active;
    @SerializedName("FullName")
    @Expose
    private String fullName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getImage() {

        if (image.equals(""))
        {
            image = "https://www.pngitem.com/pimgs/m/557-5578368_empty-profile-picture-icon-hd-png-download.png";
        }

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
