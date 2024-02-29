package com.backend.taskmanagement.contoller;

import com.backend.taskmanagement.model.Customer;
import com.backend.taskmanagement.model.RegisterCustomer;
import com.backend.taskmanagement.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CustomerController {
    private final CustomerService service;
    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody RegisterCustomer registerCustomer){
        return ResponseEntity.ok(service.addCustomer(registerCustomer));
    }
    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> customers = service.getAllCustomer();
        return ResponseEntity.ok(customers);
    }
    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id){
        Customer customer = service.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
    @PutMapping("/updateCustomerById/{id}")
    public ResponseEntity<String> updateCustomerById(@PathVariable("id") long id, @RequestBody RegisterCustomer registerCustomer){
        return ResponseEntity.ok(service.updateCustomerById(id, registerCustomer));
    }
    @DeleteMapping("/deleteCustomerById/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("id") long id){
        return ResponseEntity.ok(service.deleteCustomerById(id));
    }
}