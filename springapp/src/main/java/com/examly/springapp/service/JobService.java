package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Job;
import com.examly.springapp.repository.JobRepo;
import java.util.*;

@Service
public interface JobService {

  Job getJobsById(int jobId);

  boolean deleteJobs(int jobId);

  List<Job> getAllJobs();

  Job updateJobs(int jobId, Job job);

  Job addJobs(Job job);

  Job createJob(Job job);

  Job updateJob(int id,Job job);
  Optional<Job> getJobByID(int id);
  //List<Job> getAllJobs();


   

}
