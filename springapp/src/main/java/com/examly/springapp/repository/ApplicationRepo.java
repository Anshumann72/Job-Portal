package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Application;
import com.examly.springapp.model.Job;
import com.examly.springapp.model.User;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Integer> {

    List<Application> findByJob(Job job);

    boolean existsByUserAndJob(User user,Job job);

}
