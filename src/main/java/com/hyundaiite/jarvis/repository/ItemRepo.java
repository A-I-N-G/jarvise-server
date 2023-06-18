package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    Optional<Item> findByContent(String content);

}
