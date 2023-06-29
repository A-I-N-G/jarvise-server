package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.CoverLetterItemKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoverLetterItemKeywordRepo extends JpaRepository<CoverLetterItemKeyword, Long> {

    Optional<CoverLetterItemKeyword> findByCoverLetterItemIdAndKeywordId(Long coverLetterItemId, Long keywordId);

}
