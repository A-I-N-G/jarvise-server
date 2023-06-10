package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyRepo extends JpaRepository<Apply, Long> {
}
