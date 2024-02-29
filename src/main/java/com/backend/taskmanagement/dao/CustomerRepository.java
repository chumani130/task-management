package com.backend.taskmanagement.dao;

import com.backend.taskmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}