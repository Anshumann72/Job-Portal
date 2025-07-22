

package com.examly.springapp.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Job {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int jobId;
private String title;
private String description;
private String company;
private String location;
private double salary;
private LocalDate postedDate;
private LocalDate deadline;
private String jobType;
private String experienceLevel;
@OneToMany(mappedBy = "job",cascade = CascadeType.ALL,orphanRemoval = true)
private List<Application> applications;
@ManyToOne
@JsonBackReference
private User user;

public double getSalary() {
    return salary;
}
public void setSalary(double salary) {
    this.salary = salary;
}
public LocalDate getPostedDate() {
    return postedDate;
}
public void setPostedDate(LocalDate postedDate) {
    this.postedDate = postedDate;
}
public LocalDate getDeadline() {
    return deadline;
}
public void setDeadline(LocalDate deadline) {
    this.deadline = deadline;
}
public String getJobType() {
    return jobType;
}
public void setJobType(String jobType) {
    this.jobType = jobType;
}
public String getExperienceLevel() {
    return experienceLevel;
}
public void setExperienceLevel(String experienceLevel) {
    this.experienceLevel = experienceLevel;
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


public List<Application> getApplications() {
    return applications;
}
public void setApplications(List<Application> applications) {
    this.applications = applications;
}
public Job(String title, String description, String company, String location) {
    
    this.title = title;
    this.description = description;
    this.company = company;
    this.location = location;
}
public Job() {
}
public User getUser() {
    return user;
}
public void setUser(User user) {
    this.user = user;
}
@Override
public String toString() {
    return "Job [jobId=" + jobId + ", title=" + title + ", description=" + description + ", company=" + company
            + ", location=" + location + ", salary=" + salary + ", postedDate=" + postedDate + ", deadline=" + deadline
            + ", jobType=" + jobType + ", experienceLevel=" + experienceLevel + "]";
} 


}

