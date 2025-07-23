package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query("select job from Job job where job.location=?1")
    List<Job> getJobsByLocations(String location);

    @Query("select job from Job job where job.salary>=?1 and job.salary<=?2")
    List<Job> getJobsBySalary(double minsalary,double maxsalary);

    @Query("select job from Job job where job.jobType=?1")
    List<Job> getJobsByType(String jobType);

}

