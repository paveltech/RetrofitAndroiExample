package com.example.android.retrofitandroiexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by android on 9/21/2017.
 */

public class Actorlist {


    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("photo")
    @Expose
    public String photo;
    @SerializedName("new_photo")
    @Expose
    public String newPhoto;
    @SerializedName("gender")
    @Expose
    public String gender;
    @SerializedName("birth_date")
    @Expose
    public String birthDate;
    @SerializedName("birth_place")
    @Expose
    public String birthPlace;
    @SerializedName("height")
    @Expose
    public String height;
    @SerializedName("weight")
    @Expose
    public String weight;
    @SerializedName("nick_name")
    @Expose
    public String nickName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNewPhoto() {
        return newPhoto;
    }

    public void setNewPhoto(String newPhoto) {
        this.newPhoto = newPhoto;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
