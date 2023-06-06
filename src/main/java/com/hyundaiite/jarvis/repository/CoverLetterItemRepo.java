package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.CoverLetterItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverLetterItemRepo extends JpaRepository<CoverLetterItem, Long> {
}
