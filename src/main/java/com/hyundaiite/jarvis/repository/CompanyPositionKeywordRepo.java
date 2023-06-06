package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.CompanyPositionKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyPositionKeywordRepo extends JpaRepository<CompanyPositionKeyword, Long> {
}
