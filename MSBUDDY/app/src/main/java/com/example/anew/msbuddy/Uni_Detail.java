package com.example.anew.msbuddy;

/**
 * Created by Admin on 13-03-2018.
 */

public class Uni_Detail {
    private String Name;
    private String Address;
    private String City;
    private String State;
    private String Web;
    private String Location;
    private String Description;
    private Double Fees;
    private int Rank;

    public Uni_Detail() {
    }

    public Uni_Detail(String Name, String Address, String City, String State, String Web, String Location, String Description, Double Fees, int Rank) {
        this.Name = Name;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.Web = Web;
        this.Location = Location;
        this.Description = Description;
        this.Fees = Fees;
        this.Rank = Rank;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getWeb() {
        return Web;
    }

    public void setWeb(String web) {
        Web = web;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        this.Rank = rank;
    }

    public Double getFees() {
        return Fees;
    }

    public void setFees(Double fees) {
        Fees = fees;
    }
}
