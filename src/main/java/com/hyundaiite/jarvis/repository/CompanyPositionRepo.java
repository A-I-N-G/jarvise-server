package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.Company;
import com.hyundaiite.jarvis.entity.CompanyPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface CompanyPositionRepo extends JpaRepository<CompanyPosition, Long> {
    Optional<CompanyPosition> findByCompanyIdAndPositionId(Long companyId, Long positionId);

    ArrayList<CompanyPosition> findByCompany(Company company);

}
