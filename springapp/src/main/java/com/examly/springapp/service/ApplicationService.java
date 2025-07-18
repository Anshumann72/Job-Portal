package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Application;

public interface ApplicationService {

    List<Application> getAllApplications();
    Application getApplicationById(int id);
    Application saveApplication(Application application);
    Application updateApplication(int id,Application application);
    void deleteApplication(int id);
    List<Application> getApplicationByUserId(int userId);
   // List<Application> getApplicationByUserId();

}
