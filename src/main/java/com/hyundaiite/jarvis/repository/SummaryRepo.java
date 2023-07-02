package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.CoverLetterItem;
import com.hyundaiite.jarvis.entity.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepo extends JpaRepository<Summary, Long> {
    Summary findByCoverLetterItem(CoverLetterItem coverLetterItem);

}
