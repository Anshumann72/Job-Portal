package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.examly.springapp.model.Job;
import com.examly.springapp.repository.JobRepo;

@Service
public class JobServiceImpl implements JobService {


     @Autowired
    JobRepo jobRepo;


    

    public Job addJobs(Job job) {
      jobRepo.save(job);
      return job;
    }

    public Job updateJobs(int jobId,Job job) {
      Optional<Job> o=jobRepo.findById(jobId);
      if(o.isPresent()){
        Job j2=o.get();
        j2.setCompany(job.getCompany());
        j2.setDescription(job.getDescription());
        j2.setLocation(job.getDescription());
        j2.setTitle(job.getTitle());
        jobRepo.save(j2);
        return j2;
      }
      return null;
    }

    public List<Job> getAllJobs() {
       return jobRepo.findAll();
    }

    public Job getJobsById(int jobId) {
       return jobRepo.findById(jobId).orElse(null);
    }

    public boolean deleteJobs(int jobId) {
      jobRepo.deleteById(jobId);
      return true;
    }

    @Override
    public Job createJob(Job job) {
       return jobRepo.save(job);
    }

    @Override
    public Job updateJob(int id, Job job) {
       if(jobRepo.existsById(id)){
        job.setJobId(id);
        return jobRepo.save(job);
       }
       return null;
    }

    @Override
    public Optional<Job> getJobByID(int id) {
        return jobRepo.findById(id);
      }
      

    @Override
    public void deleteJob(int id) {
      if(jobRepo.existsById(id)){
          jobRepo.deleteById(id);
       }
       
    }

}
