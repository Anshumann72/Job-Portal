

package com.examly.springapp.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long userId;
@Column(unique = true)
private String username;
private String password;
private String role;
// private LocalDate dob;
@OneToMany(mappedBy = "user")
@JsonBackReference
private List<Job> jobs;
@OneToMany(mappedBy = "user")
@JsonIgnore
private List<Application> applications;
// @OneToOne(mappedBy = "user")
// private UserProfile userProfile;

public long getUserId() {
    return userId;
}
public void setUserId(long userId) {
    this.userId = userId;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getRole() {
    return role;
}
public void setRole(String role) {
    this.role = role;
}
public List<Job> getJobs() {
    return jobs;
}
public void setJobs(List<Job> jobs) {
    this.jobs = jobs;
}
public List<Application> getApplications() {
    return applications;
}
public void setApplications(List<Application> applications) {
    this.applications = applications;
}
// public LocalDate getDob() {
//     return dob;
// }
// public void setDob(LocalDate dob) {
//     this.dob = dob;
// }


}

