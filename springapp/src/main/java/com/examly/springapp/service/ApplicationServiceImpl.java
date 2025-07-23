package com.examly.springapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ApplicationNotFoundException;
import com.examly.springapp.exception.InvalidUserException;
import com.examly.springapp.exception.JobNotFoundException;
import com.examly.springapp.exception.UserAlreadyApplied;
import com.examly.springapp.model.Application;
import com.examly.springapp.model.Job;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.ApplicationRepo;
import com.examly.springapp.repository.JobRepository;
import com.examly.springapp.repository.UserRepo;

@Service
public class ApplicationServiceImpl implements ApplicationService{
@Autowired
ApplicationRepo applicationRepo;
@Autowired
JobRepository jobRepository;
@Autowired
UserRepo userRepo;

@Override
public Application saveApplication(Application application) {
    return applicationRepo.save(application);
}
@Override
public List<Application> getAllApplications() {
    return applicationRepo.findAll();
}
@Override
public Application getApplicationById(int id) {
   return applicationRepo.findById(id).orElse(null);
}
@Override
// extra
public Application updateApplication(int id, Application application) {
    if(applicationRepo.existsById(id)){
        application.setApplicationId(id);
        return applicationRepo.save(application);
    }
    throw new ApplicationNotFoundException("application not found");
}
@Override
// extra
public void deleteApplication(int id) {
   if(applicationRepo.existsById(id)){
    applicationRepo.deleteById(id);
   }
   throw new ApplicationNotFoundException("Application not found");
}
public List<Application> getApplicationsByUserId(long userId) {
    User user=userRepo.findById(userId).orElse(null);
    if(user==null){
       throw new UsernameNotFoundException("Application not found with the current user");
    }
    return user.getApplications();
}
// extra
public Application createApplicationByUser(Application application, int jobId, long userId) {
    User user=userRepo.findById(userId).orElse(null);
    if(user==null){
        throw new UsernameNotFoundException("User not found");
    }
    if(user.getRole().equals("Admin")){
        throw new InvalidUserException("Invalid user");
    }
    Job job=jobRepository.findById(jobId).orElse(null);
    if(job==null){
        throw new JobNotFoundException("Job not available");
    }
    // if(job.getDeadline().isBefore(LocalDate.now())){
    //     throw new JobNotFoundException("Job not available");
    // }
    if(applicationRepo.existsByUserAndJob(user,job)){
        throw new UserAlreadyApplied("User already applied for this job");
    }
    application.setApplicationDate(LocalDate.now());
    application.setStatus("Applied succesfully");
    application.setJob(job);
    application.setUser(user);
    return applicationRepo.save(application);

}
// public Application updateApplicationByUser(int id, Application application) {
//    Application existingApplication=applicationRepo.findById(id).orElse(null);
//    if(existingApplication==null){
//     throw new ApplicationNotFoundException("Application not found");
//    }
//    application.setApplicationId(id);
//    application.setJob(existingApplication.getJob());
//    application.setUser(existingApplication.getUser());
//    return applicationRepo.save(application);
// }
public List<Application> getAllApplicationsByJobId(int jobId) {
   Job job=jobRepository.findById(jobId).orElse(null);
   if(job==null){
    throw new JobNotFoundException("application not found with jobId");
   }
   return job.getApplications();
}

public Application updateApplicationStatus(int id, Application application) {
    Application existingApplication=applicationRepo.findById(id).orElse(null);
    if(existingApplication==null){
     throw new ApplicationNotFoundException("Application not found");
    }
    application.setApplicationId(id);
    application.setJob(existingApplication.getJob());
    application.setUser(existingApplication.getUser());
    return applicationRepo.save(application);
}

}

