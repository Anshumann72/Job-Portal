
package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Application;
import com.examly.springapp.model.Job;
import com.examly.springapp.model.User;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Integer>{

    boolean existsByUserAndJob(User user, Job job);
    

}