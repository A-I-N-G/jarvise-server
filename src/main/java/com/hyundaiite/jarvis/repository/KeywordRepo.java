package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepo extends JpaRepository<Keyword, Long> {
}
