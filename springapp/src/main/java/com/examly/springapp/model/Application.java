package com.examly.springapp.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Application {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String status;
    private int yearsOfExperience;
    private String skills;
    private Date applicationDate;
    private String locationPreference;

    @ManyToOne
    @JoinColumn(name = "job_id")
    @JsonBackReference
    private Job job;


    public Application() {
    }
    public Application(int id, String status, int yearsOfExperience, String skills, Date applicationDate,
            String locationPreference, Job job) {
        this.id = id;
        this.status = status;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = skills;
        this.applicationDate = applicationDate;
        this.locationPreference = locationPreference;
        this.job = job;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public Date getApplicationDate() {
        return applicationDate;
    }
    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }
    public String getLocationPreference() {
        return locationPreference;
    }
    public void setLocationPreference(String locationPreference) {
        this.locationPreference = locationPreference;
    }
    public Job getJob() {
        return job;
    }
    public void setJob(Job job) {
        this.job = job;
    }
    

    

}
