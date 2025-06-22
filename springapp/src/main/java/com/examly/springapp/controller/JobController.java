package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.examly.springapp.model.Job;
@RestController
public class JobController {


     @GetMapping("api/test/job")
    public ArrayList<Job> getJob(){
        ArrayList<Job> jobs=new ArrayList<>();
        jobs.add(new Job(1,"SWE","Spring Boot Development","LTI","Banglore"));
        return jobs;

    }



}
