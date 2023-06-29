package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.CoverLetterItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CoverLetterItemRepo extends JpaRepository<CoverLetterItem, Long> {
    ArrayList<CoverLetterItem> findByCoverLetterId(Long coverLetterId);

}
