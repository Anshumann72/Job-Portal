
package com.examly.springapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.InvalidDateException;
import com.examly.springapp.exception.InvalidUserException;
import com.examly.springapp.exception.JobNotFoundException;
import com.examly.springapp.exception.UserNotExists;
import com.examly.springapp.model.Job;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.JobRepository;
import com.examly.springapp.repository.UserRepo;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;
    @Autowired
    UserRepo userRepo;
    @Override
    public Job createJob(Job job) {
        job.setPostedDate(LocalDate.now());
        job = jobRepository.save(job);
        return job;
    }
    @Override
    public Job updateJob(Job job, int jobId) {
        if (jobRepository.existsById(jobId)) {
            job.setJobId(jobId);
            return jobRepository.save(job);
        }
        return null;
    }
    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    @Override
    public Job getJobById(int jobId) {
        return jobRepository.findById(jobId).orElse(null);
    }
    @Override
    public boolean deleteJob(int jobId) {
        if (jobRepository.existsById(jobId)) {
            jobRepository.deleteById(jobId);
            return true;
        }
        return false;
    }
    @Override
    // extra
    public List<Job> getJobByUserId(long userId) {
       User user=userRepo.findById(userId).orElse(null);
       if(user==null){
        throw new UserNotExists("user not found");
       }
       return user.getJobs();
    }
    public List<Job> getJobsByLocations(String location) {
      return jobRepository.getJobsByLocations(location);
    }
    public List<Job> getJobsBySalary(double minsalary,double maxsalary) {
        return jobRepository.getJobsBySalary(minsalary,maxsalary);
    }
    public List<Job> getJobsByType(String jobType) {
        return jobRepository.getJobsByType(jobType);
    }
    //extra
    public Job createJobByAdmin(Job job, long userId) {
        

        User existingAdmin=userRepo.findById(userId).orElse(null);
        
        if(existingAdmin==null){
            throw new UserNotExists("Admin not exists");
        }
        if(existingAdmin.getRole().equals("user")){
            throw new InvalidUserException("Invalid user to post the job");
        }
        job.setPostedDate(LocalDate.now());
        if(job.getDeadline().isBefore(job.getPostedDate())){
            throw new InvalidDateException("DeadLine is invalid");
        }
        job.setUser(existingAdmin);
        return jobRepository.save(job);
    }
    // extra
    public Job updateJobByAdmin(Job job, int jobId) {
       Job existingJob=jobRepository.findById(jobId).orElse(null);
       if(existingJob==null){
        throw new JobNotFoundException("Job not found");
       }
       job.setJobId(jobId);
       job.setUser(existingJob.getUser());
       return jobRepository.save(job);
    }

}

