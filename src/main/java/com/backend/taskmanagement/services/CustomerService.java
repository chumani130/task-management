package com.backend.taskmanagement.services;

import com.backend.taskmanagement.model.Customer;
import com.backend.taskmanagement.model.RegisterCustomer;
import java.util.List;
public interface CustomerService {
//    static Customer getUserByEmail(String email) {
//
//    }

    String addCustomer(RegisterCustomer customer);
    Customer getCustomerById(long id);
    List<Customer> getAllCustomer();
    String updateCustomerById(long id, RegisterCustomer registerCustomer);
    String deleteCustomerById(long id);
}