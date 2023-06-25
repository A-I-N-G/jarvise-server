package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.CompanyPositionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CompanyPositionItemRepo extends JpaRepository<CompanyPositionItem, Long> {
    Optional<CompanyPositionItem> findByCompanyPositionIdAndItemId(Long companyPositionId, Long itemId);

    ArrayList<CompanyPositionItem> findByCompanyPositionId(Long companyPositionId);

}
