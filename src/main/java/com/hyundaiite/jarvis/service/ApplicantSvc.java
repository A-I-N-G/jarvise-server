package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.entity.Applicant;
import com.hyundaiite.jarvis.repository.ApplicantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicantSvc {

    @Autowired
    private ApplicantRepo applicantRepo;

    public Applicant saveApplicant(Applicant applicant) {
        return applicantRepo.save(applicant);
    }

    public Long deleteApplicant(Long id) {
        applicantRepo.deleteById(id);
        return id;
    }

    public Optional<Applicant> selectApplicant(Long id) {
        return applicantRepo.findById(id);
    }
}
