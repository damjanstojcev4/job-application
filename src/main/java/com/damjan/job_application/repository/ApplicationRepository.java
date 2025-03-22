package com.damjan.job_application.repository;

import com.damjan.job_application.entity.Application;
import com.damjan.job_application.entity.Job;
import com.damjan.job_application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    // Find all applications for a specific job
    List<Application> findByJob(Job job);

    // Find all applications by a specific user (Job Seeker)
    List<Application> findByUser(User user);

    // Find application by job and user (Check if user has applied for a job)
    Optional<Application> findByJobAndUser(Job job, User user);

    // Find applications by status (Filter by pending, approved, rejected)
    List<Application> findByStatus(Application.Status status);

    // Find all applications for jobs posted by a specific recruiter
    @Query("SELECT a FROM Application a WHERE a.job.recruiter = :recruiter")
    List<Application> findByRecruiter(@Param("recruiter") User recruiter);
}
