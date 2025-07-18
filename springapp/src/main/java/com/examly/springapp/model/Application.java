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
    private int applicationId;
    private String status;
    private int yearsOfExperience;
    private String skills;
    private Date applicationDate;
    private String locationPreference;

    @ManyToOne
    @JoinColumn(name = "job_id")
    @JsonBackReference
    private Job job;
    

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Application() {
    }
   
    public Application(int applicationId, String status, int yearsOfExperience, String skills, Date applicationDate,
            String locationPreference, Job job, User user) {
        this.applicationId = applicationId;
        this.status = status;
        this.yearsOfExperience = yearsOfExperience;
        this.skills = skills;
        this.applicationDate = applicationDate;
        this.locationPreference = locationPreference;
        this.job = job;
        this.user = user;
    }

    public int getApplicationId() {
        return applicationId;
    }
    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
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
