package com.hyundaiite.jarvis.controller;

import com.hyundaiite.jarvis.entity.Applicant;
import com.hyundaiite.jarvis.service.ApplicantSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/applicants")
public class ApplicantCtl {
    @Autowired
    private ApplicantSvc applicantSvc;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveApplicant(@RequestBody Applicant applicant) {
        Applicant savedApplicant = applicantSvc.saveApplicant(applicant);
        return savedApplicant.getId();
    }

    @GetMapping("/{id}")
    public Applicant selectApplicant(@PathVariable Long id) {
        Applicant selectedApplicant = applicantSvc.selectApplicant(id).orElseThrow();
        return selectedApplicant;
    }

    @PutMapping("/{id}")
    public Long updateApplicant(@RequestBody Applicant applicant) {
        Applicant updatedApplicant = applicantSvc.saveApplicant(applicant);
        return updatedApplicant.getId();
    }

    @DeleteMapping("/{id}")
    public Long deleteApplicant(@PathVariable Long id) {
        return applicantSvc.deleteApplicant(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
