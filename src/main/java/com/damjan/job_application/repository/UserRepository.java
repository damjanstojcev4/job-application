package com.damjan.job_application.repository;

import com.damjan.job_application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findById(Long id); // for admins or user profile updates

    Optional<User> findByEmail(String email); // To authenticate users during login or registration.

    List<User> findByRole(User.Role role); // Retrieve users based on their role

    List<User> findByFullNameContainingIgnoreCase(String fullName); // Search users by name (case-insensitive)
}
