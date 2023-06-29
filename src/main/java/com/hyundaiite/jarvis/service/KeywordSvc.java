package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.entity.Keyword;
import com.hyundaiite.jarvis.repository.KeywordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeywordSvc {
    @Autowired
    private KeywordRepo keywordRepo;

    public Keyword saveKeyword(Keyword keyword) {
        return keywordRepo.save(keyword);
    }

    public Long deleteKeyword(Long id) {
        keywordRepo.deleteById(id);
        return id;
    }

    public List<Keyword> selectKeywords() {
        return keywordRepo.findAll();
    }

    public Optional<Keyword> selectKeyword(Long id) {
        return keywordRepo.findById(id);
    }
}
