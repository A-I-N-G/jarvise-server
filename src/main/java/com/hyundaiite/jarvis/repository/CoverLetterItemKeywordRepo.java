package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.CoverLetterItemKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverLetterItemKeywordRepo extends JpaRepository<CoverLetterItemKeyword, Long> {
}
