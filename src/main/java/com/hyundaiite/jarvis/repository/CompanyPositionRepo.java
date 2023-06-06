package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.CompanyPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyPositionRepo extends JpaRepository<CompanyPosition, Long> {
}
