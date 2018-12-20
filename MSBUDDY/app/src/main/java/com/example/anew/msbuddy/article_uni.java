package com.example.anew.msbuddy;

import android.os.Parcel;

import java.io.Serializable;

/**
 * Created by New on 27/01/2018.
 */
public class article_uni implements Serializable {

    private String name;
    private String rank;
    private String location;
    private String web;
    private String fees;
    private String detail;



    public article_uni() {
    }


    public article_uni(String name , String rank , String location , String detail , String fees , String web) {
        this.detail =detail;
        this.fees = fees;
        this.name = name;
        this.location = location;
        this.rank = rank;
        this.web = web;

    }

    protected article_uni(Parcel in) {
        name = in.readString();
        rank = in.readString();
        location = in.readString();
        web = in.readString();
        fees = in.readString();
        detail = in.readString();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String detail) {
        this.web = web;
    }

}
