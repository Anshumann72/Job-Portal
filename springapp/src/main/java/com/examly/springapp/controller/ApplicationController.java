package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Application;
import com.examly.springapp.service.ApplicationService;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/api/application/user/{userId}")
    public ResponseEntity<?> getAppListById(@PathVariable int userId){
      List<Application> li=applicationService.getApplicationByUserId(userId);
      if(!li.isEmpty())
    }
}
