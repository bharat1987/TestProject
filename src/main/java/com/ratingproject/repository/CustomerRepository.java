package com.ratingproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratingproject.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String>  {

}
