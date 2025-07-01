package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.*;

@Entity
public class Job {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int jobId;
 private String title;
 private String description;
 private String company;
 private String location;


 
 private List<Application> applications=new ArrayList<>();


  
 public Job() {
}
 public Job(int jobId, String title, String description, String company, String location) {
    this.jobId = jobId;
    this.title = title;
    this.description = description;
    this.company = company;
    this.location = location;
}
 public int getJobId() {
    return jobId;
 }
 public void setJobId(int jobId) {
    this.jobId = jobId;
 }
 public String getTitle() {
    return title;
 }
 public void setTitle(String title) {
    this.title = title;
 }
 public String getDescription() {
    return description;
 }
 public void setDescription(String description) {
    this.description = description;
 }
 public String getCompany() {
    return company;
 }
 public void setCompany(String company) {
    this.company = company;
 }
 public String getLocation() {
    return location;
 }
 public void setLocation(String location) {
    this.location = location;
 }



 
 
}
