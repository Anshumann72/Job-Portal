package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.examly.springapp.model.Job;
import com.examly.springapp.service.JobService;



@RestController
public class JobController {


    @Autowired
    JobService jobService;
    //  @GetMapping("api/test/job")
    // public ArrayList<Job> getJob(){
    //     ArrayList<Job> jobs=new ArrayList<>();
    //     jobs.add(new Job(1,"SWE","Spring Boot Development","LTI","Banglore"));
    //     return jobs;

    // }

    @PostMapping("api/jobs")
    public ResponseEntity<?> addJobs(@RequestBody Job job){
        Job j1=jobService.addJobs(job);
        return new ResponseEntity<>(j1,HttpStatus.valueOf(201));
    }

    @PutMapping("api/jobs/{jobsId}")
    public ResponseEntity<?> updateJobs(@PathVariable int jobId,@RequestBody Job job){
        Job j1=jobService.updateJobs(jobId,job);
        return new ResponseEntity<>(j1,HttpStatus.valueOf(200));
    }


    @GetMapping("api/jobs")
    public ResponseEntity<?> getAllJobs(){
        List<Job> j1=jobService.getAllJobs();
        return new ResponseEntity<>(j1,HttpStatus.valueOf(200));
    }

    @GetMapping("api/jobs/{jobId}")
    public ResponseEntity<?> getJobsById(@PathVariable int jobId){
        Job j1=jobService.getJobsById(jobId);
        return new ResponseEntity<>(j1,HttpStatus.valueOf(200));
    }


    @DeleteMapping("api/jobs/{jobId}")
    public ResponseEntity<?> deleteJobs(@PathVariable int jobId){
        boolean j1=jobService.deleteJobs(jobId);
        return new ResponseEntity<>(j1,HttpStatus.valueOf(200));
    }







}
