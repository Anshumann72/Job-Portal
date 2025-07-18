package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Application;
import com.examly.springapp.repository.ApplicationRepo;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationRepo applicationRepo;

    @Override
    public List<Application> getAllApplications() {
        return applicationRepo.findAll();
    }

    @Override
    public Application getApplicationById(int id) {
       return applicationRepo.findById(id).orElse(null);
    }

    @Override
    public Application saveApplication(Application application) {
      return applicationRepo.save(application);
    }

    @Override
    public Application updateApplication(int id, Application application) {
     Application a=applicationRepo.findById(id).orElse(null);
      a.setApplicationDate(application.getApplicationDate());
      a.setLocationPreference(null);
    }

    @Override
    public void deleteApplication(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteApplication'");
    }

    @Override
    public List<Application> getApplicationByUserId(int UserId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getApplicationByUserId'");
    }

   

}
