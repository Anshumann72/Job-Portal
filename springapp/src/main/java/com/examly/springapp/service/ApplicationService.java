
package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Application;
@Service
public interface ApplicationService {

    List<Application>getAllApplications();
    Application getApplicationById(int id);
    Application saveApplication(Application application);
    Application updateApplication(int id,Application application);
    void deleteApplication(int id);
    public List<Application> getApplicationsByUserId(long userId);
}