package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Job;
import com.examly.springapp.service.JobServiceImpl;
import com.examly.springapp.service.UserServiceImpl;

@RestController
@CrossOrigin("*")
public class JobController {

    @Autowired
    JobServiceImpl jobServiceImpl;
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/api/jobs")
    public ResponseEntity<?> createJob(@RequestBody Job job) {
        job = jobServiceImpl.createJob(job);
        if(job!=null)
        return ResponseEntity.status(201).body(job);
        return ResponseEntity.status(404).body(null);
    }

    @PostMapping("/api/jobs/{userId}")
    public ResponseEntity<?> createJobByAdmin(@RequestBody Job job,@PathVariable long userId) {
        job = jobServiceImpl.createJobByAdmin(job,userId);
        return ResponseEntity.status(201).body(job);
    }

    @PutMapping("/api/jobs/{jobId}")
    public ResponseEntity<?> updateJob(@RequestBody Job job, @PathVariable int jobId) {
        job = jobServiceImpl.updateJob(job, jobId);
        return ResponseEntity.status(200).body(job);
    }

    @GetMapping("/api/jobs")
    public ResponseEntity<?> getAllJobs() {
        List<Job> list = jobServiceImpl.getAllJobs();
        if(!list.isEmpty())
        return ResponseEntity.status(200).body(list);
        return ResponseEntity.status(404).body("no jobs found");
    }

    @GetMapping("/api/jobs/{jobId}")
    public ResponseEntity<?> getJobById(@PathVariable int jobId) {
        Job job = jobServiceImpl.getJobById(jobId);
        if(job!=null)
        return ResponseEntity.status(200).body(job);
        return ResponseEntity.status(404).body("Job not found");
    }

    @DeleteMapping("/api/jobs/{jobId}")
    public ResponseEntity<?> deleteJob(@PathVariable int jobId) {
        boolean flag = jobServiceImpl.deleteJob(jobId);
        if(flag)
        return ResponseEntity.status(200).body(flag);
        return ResponseEntity.status(404).body("Job not exists to delete");
    }

    @GetMapping("/api/jobs/user/{userId}")
    public ResponseEntity<?> getJobByUserId(@PathVariable long userId){
        List<Job> list=jobServiceImpl.getJobByUserId(userId);
        if(!list.isEmpty())
        return ResponseEntity.status(200).body(list);
        return ResponseEntity.status(404).body("There are no jobs");
    }

    @GetMapping("/api/jobs/location/{location}")
    public ResponseEntity<?> getJobsByLocations(@PathVariable String location){
        List<Job> list=jobServiceImpl.getJobsByLocations(location);
        if(!list.isEmpty())
        return ResponseEntity.status(200).body(list);
        return ResponseEntity.status(404).body("There are no jobs");
    }

    @GetMapping("/api/jobs/salary/{minsalary}/{maxsalary}")
    public ResponseEntity<?> getJobsBySalary(@PathVariable double minsalary,@PathVariable double maxsalary){
        List<Job> list=jobServiceImpl.getJobsBySalary(minsalary,maxsalary);
        if(!list.isEmpty())
        return ResponseEntity.status(200).body(list);
        return ResponseEntity.status(404).body("There are no jobs");
    }

    @GetMapping("/api/jobs/type/{jobType}")
    public ResponseEntity<?> getJobsByType(@PathVariable String jobType){
        List<Job> list=jobServiceImpl.getJobsByType(jobType);
        if(!list.isEmpty())
        return ResponseEntity.status(200).body(list);
        return ResponseEntity.status(404).body("There are no jobs");
    }
    // extra
    @PutMapping("/api/jobs/user/{jobId}")
    public ResponseEntity<?> updateJobByAdmin(@RequestBody Job job, @PathVariable int jobId) {
        job = jobServiceImpl.updateJobByAdmin(job, jobId);
        return ResponseEntity.status(200).body(job);
    }

}



