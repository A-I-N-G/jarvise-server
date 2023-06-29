package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoverLetterRepo extends JpaRepository<CoverLetter, Long> {
    Optional<CoverLetter> findByApplyId(Long applyId);

}
