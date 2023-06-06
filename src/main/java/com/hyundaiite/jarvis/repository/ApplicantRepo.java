package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepo extends JpaRepository<Applicant, Long> {
}
