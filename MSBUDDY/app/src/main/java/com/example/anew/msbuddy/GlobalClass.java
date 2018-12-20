package com.example.anew.msbuddy;

import android.app.Application;
import android.location.Address;
import android.util.EventLogTags;

/**
 * Created by Admin on 11-03-2018.
 */

public class GlobalClass extends Application {


    private int count;
    private String Address,Name,City,Description,Location,State,Web;
    private int Rank;
    private Double Fees;
    private String apply_for_sem;
    private String cuurent_Ed_level;
    private int quant,verbal;
    private float reading,listening,writing,speaking;
    private float awa;
    private int backlogs;
    private float cgpa,workexp,research_paper;
    private  int tofelorielts;
    public GlobalClass() {

        this.quant = 0;
        this.verbal=0;
        this.awa=0;
        this.reading=0;
        this.listening=0;
        this.writing=0;
        this.speaking=0;
        this.cgpa=0;
        this.backlogs=0;
        this.workexp=0;
        this.research_paper=0;
        this.tofelorielts=0;

    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public String getApply_for_sem() {
        return apply_for_sem;
    }

    public void setApply_for_sem(String apply_for_sem) {
        this.apply_for_sem = apply_for_sem;
    }

    public String getCuurent_Ed_level() {
        return cuurent_Ed_level;
    }

    public void setCuurent_Ed_level(String cuurent_Ed_level) {
        this.cuurent_Ed_level = cuurent_Ed_level;
    }


    public int getVerbal() {
        return verbal;
    }

    public void setVerbal(int verbal) {
        this.verbal = verbal;
    }

    public float getAwa() {
        return awa;
    }

    public void setAwa(float awa) {
        this.awa = awa;
    }

    public float getReading() {
        return reading;
    }

    public void setReading(float reading) {
        this.reading = reading;
    }

    public float getListening() {
        return listening;
    }

    public void setListening(float listening) {
        this.listening = listening;
    }

    public float getWriting() {
        return writing;
    }

    public void setWriting(float writing) {
        this.writing = writing;
    }

    public float getSpeaking() {
        return speaking;
    }

    public void setSpeaking(float speaking) {
        this.speaking = speaking;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public int getBacklogs() {
        return backlogs;
    }

    public void setBacklogs(int backlogs) {
        this.backlogs = backlogs;
    }

    public float getCgpa() {
        return cgpa;
    }


    public float getWorkexp() {
        return workexp;
    }

    public void setWorkexp(float workexp) {
        this.workexp = workexp;
    }

    public float getResearch_paper() {
        return research_paper;
    }

    public void setResearch_paper(float research_paper) {
        this.research_paper = research_paper;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
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

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public Double getFees() {
        return Fees;
    }

    public void setFees(Double fees) {
        Fees = fees;
    }

    public int getTofelorielts() {
        return tofelorielts;
    }

    public void setTofelorielts(int tofelorielts1) {
        this.tofelorielts = tofelorielts1;
    }
}
