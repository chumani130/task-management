//package com.backend.taskmanagement.controller;
//import com.backend.taskmanagement.model.Customer;
//import com.backend.taskmanagement.services.CustomerService;
//import org.springframework.ui.Model;
//import com.backend.taskmanagement.services.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.security.Principal;
//
//@Controller
//public class ProfileController {
//
//    private CustomerService customerService;
//    private TaskService taskService;
//
//    @Autowired
//    public ProfileController(CustomerService customerService, TaskService taskService) {
//        this.userService = customerService;
//        this.taskService = taskService;
//    }
//
//    @GetMapping("/profile")
//    public String showProfilePage(Model model, Principal principal) {
//        String email = principal.getName();
//        Customer customer = CustomerService.getUserByEmail(email);
//        model.addAttribute("user", user);
//        model.addAttribute("tasksOwned", taskService.findByOwnerOrderByDateDesc(user));
//        return "views/profile";
//    }
//
//    @GetMapping("/profile/mark-done/{taskId}")
//    public String setTaskCompleted(@PathVariable Long taskId) {
//        taskService.setTaskCompleted(taskId);
//        return "redirect:/profile";
//    }
//
//    @GetMapping("/profile/unmark-done/{taskId}")
//    public String setTaskNotCompleted(@PathVariable Long taskId) {
//        taskService.setTaskNotCompleted(taskId);
//        return "redirect:/profile";
//    }
//
//}