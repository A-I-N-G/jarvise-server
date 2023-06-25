package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KeywordRepo extends JpaRepository<Keyword, Long> {
    Optional<Keyword> findByName(String name);

}
