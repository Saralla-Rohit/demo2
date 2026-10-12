package com.rohit.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohit.demo2.entity.RegistrationDetail;


@Repository
public interface RegistrationRepository extends 
        JpaRepository<RegistrationDetail, Integer> {

}
