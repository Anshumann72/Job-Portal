
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

import com.examly.springapp.model.Application;
import com.examly.springapp.model.Job;
import com.examly.springapp.service.ApplicationServiceImpl;

@RestController
@CrossOrigin("*")
public class ApplicationController {
@Autowired
ApplicationServiceImpl applicationServiceImpl;

@PostMapping("/api/applications")
public ResponseEntity<?> saveApplication(@RequestBody Application application){
    application=applicationServiceImpl.saveApplication(application);
    return ResponseEntity.status(201).body(application);
}
// extra
@PostMapping("/api/applications/{jobId}/{userId}")
public ResponseEntity<?> createApplicationByUser(@RequestBody Application application,@PathVariable int jobId,@PathVariable long userId){
    application=applicationServiceImpl.createApplicationByUser(application,jobId,userId);
    return ResponseEntity.status(201).body(application);
}

@GetMapping("api/applications")
public ResponseEntity<?> getAllApplications(){
    List<Application> list=applicationServiceImpl.getAllApplications();
    return ResponseEntity.status(200).body(list);
}

@GetMapping("api/applications/{id}")
public ResponseEntity<?> getApplicationById(@PathVariable int id){
    Application application=applicationServiceImpl.getApplicationById(id);
    return ResponseEntity.status(200).body(application);
}

@PutMapping("api/applications/{id}")
public ResponseEntity<?> updateApplication(@RequestBody Application application,@PathVariable int id){
     application=applicationServiceImpl.updateApplication(id,application);
     return ResponseEntity.status(200).body(application);
}

// @PutMapping("api/applications/userandjob/{id}")
// public ResponseEntity<?> updateApplicationByUser(@RequestBody Application application,@PathVariable int id){
//      application=applicationServiceImpl.updateApplicationByUser(id,application);
//      return ResponseEntity.status(200).body(application);
// }
@DeleteMapping("api/applications/{id}")
public ResponseEntity<?> deleteApplication(@PathVariable int id){
     applicationServiceImpl.deleteApplication(id);
     return ResponseEntity.status(200).body(null);
}
// extra
   @GetMapping("/api/applications/user/{userId}")
    public ResponseEntity<?> getApplicationsByUserId(@PathVariable long userId){
        List<Application> list=applicationServiceImpl.getApplicationsByUserId(userId);
        if(!list.isEmpty())
        return ResponseEntity.status(200).body(list);
        return ResponseEntity.status(404).body("There are no applications");
    }

    @GetMapping("/api/applications/job/{jobId}")
    public ResponseEntity<?> getAllApplicationByJobId(@PathVariable int jobId){
        List<Application> list=applicationServiceImpl.getAllApplicationsByJobId(jobId);
        return ResponseEntity.status(200).body(list);
    }

    @PutMapping("api/applications/status/{id}")
public ResponseEntity<?> updateApplicationStatus(@RequestBody Application application,@PathVariable int id){
     application=applicationServiceImpl.updateApplicationStatus(id,application);
     return ResponseEntity.status(200).body(application);
}

}



