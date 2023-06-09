package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.Company;
import com.hyundaiite.jarvis.entity.CompanyPositionKeyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CompanyPositionKeywordRepo extends JpaRepository<CompanyPositionKeyword, Long> {
    Optional<CompanyPositionKeyword> findByCompanyPositionIdAndKeywordId(Long positionId, Long keywordId);

    ArrayList<CompanyPositionKeyword> findByCompanyPositionId(Long companyId);

}
