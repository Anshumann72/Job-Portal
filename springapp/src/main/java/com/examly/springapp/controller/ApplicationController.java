package com.examly.springapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Application;
import com.examly.springapp.service.ApplicationService;

@RestController
@CrossOrigin("*")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/api/application/user/{userId}")
    public ResponseEntity<?> getAppListById(@PathVariable int userId){
      List<Application> li=applicationService.getApplicationByUserId(userId);
      if(!li.isEmpty()) return new ResponseEntity<>(li,HttpStatus.OK);
      return new ResponseEntity<>(HttpStatus.valueOf(400));
    }

    @GetMapping("/api/applications")
    public ResponseEntity<?> getAllAppList(){
      List<Application> li=applicationService.getAllApplications();
       return new ResponseEntity<>(li,HttpStatus.OK); 
    }
}
