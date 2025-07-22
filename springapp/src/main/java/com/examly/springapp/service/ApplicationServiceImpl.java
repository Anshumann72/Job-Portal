package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Application;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.ApplicationRepo;
import com.examly.springapp.repository.UserRepo;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    ApplicationRepo applicationRepo;

    @Autowired
    UserRepo userRepo;

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
      a.setLocationPreference(application.getLocationPreference());
      a.setSkills(application.getSkills());
      a.setStatus(application.getStatus());
      a.setYearsOfExperience(application.getYearsOfExperience());
      return applicationRepo.save(a);
    }

    @Override
    public void deleteApplication(int id) {
     if(applicationRepo.existsById(id)){
        applicationRepo.deleteById(id);
     }
    }

    @Override
    public List<Application> getApplicationByUserId(long userId) {
        User user=userRepo.findById(userId).orElse(null);
    if(user==null){
       throw new UsernameNotFoundException("Application not found with the current user");
    }
    return user.getApplications();
    }

    @Override
    public List<Application> getApplicationByUserId() {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'getApplicationByUserId'");
    }

   

}
