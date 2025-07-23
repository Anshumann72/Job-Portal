
package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Job;

@Service
public interface JobService {
    public Job createJob(Job job);

    public Job updateJob(Job job, int jobId);

    public List<Job> getAllJobs();

    public Job getJobById(int jobId);

    public boolean deleteJob(int jobId);

    public List<Job> getJobByUserId(long userId);
}

