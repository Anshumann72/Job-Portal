package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.examly.springapp.model.Job;
import com.examly.springapp.repository.JobRepo;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createJob'");
    }

    @Override
    public Job updateJob(int id, Job job) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateJob'");
    }

    @Override
    public Optional<Job> getJobByID(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getJobByID'");
    }

    @Override
    public void deleteJob(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteJob'");
    }

}
