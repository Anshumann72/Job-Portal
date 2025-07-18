package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.Application;

@Repository
public interface ApplicationRepo extends JpaRepository<Application,Integer> {

    List<Application> findBy

}
