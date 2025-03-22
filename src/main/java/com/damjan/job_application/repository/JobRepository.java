package com.damjan.job_application.repository;

import com.damjan.job_application.entity.Job;
import com.damjan.job_application.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findAll();

    List<Job>findByRecruiter(User recruiter);

    Optional<Job> findById(Long id); // Find job's details by id

    @Query("SELECT j FROM Job j WHERE " +
            "LOWER(j.title) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(j.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Job> searchByTitleOrDescription(@Param("keyword") String keyword);

    List<Job> findByLocationIgnoreCase(String location);

    List<Job> findByCompanyIgnoreCase(String company);

    @Query("SELECT j FROM Job j")
    Page<Job> findAllWithPagination(Pageable pageable);
}
