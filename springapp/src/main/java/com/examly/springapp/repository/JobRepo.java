 package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examly.springapp.model.Job;

public interface JobRepo extends JpaRepository<Job,Integer> {

    
}