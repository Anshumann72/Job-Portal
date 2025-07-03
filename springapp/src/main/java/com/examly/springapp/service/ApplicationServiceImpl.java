package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Application;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Override
    public List<Application> getAllApplications() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllApplications'");
    }

    @Override
    public Application getApplicationById() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getApplicationById'");
    }

    @Override
    public Application saveApplication(Application application) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveApplication'");
    }

    @Override
    public Application updateApplication(int id, Application application) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateApplication'");
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
