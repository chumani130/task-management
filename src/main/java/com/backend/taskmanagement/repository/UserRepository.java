//package com.backend.taskmanagement.repository;
//
//import com.backend.taskmanagement.entity.User;
//import com.backend.taskmanagement.enums.UserRole;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    Optional<User> findFirstByEmail(String email);
//
//    User findByRole(UserRole userRole);
//
//}
