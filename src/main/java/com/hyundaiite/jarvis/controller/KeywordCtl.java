package com.hyundaiite.jarvis.controller;

import com.hyundaiite.jarvis.entity.Keyword;
import com.hyundaiite.jarvis.service.KeywordSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/keywords")
public class KeywordCtl {
    @Autowired
    private KeywordSvc keywordSvc;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveKeyword(@RequestBody Keyword keyword) {
        Keyword savedKeyword = keywordSvc.saveKeyword(keyword);
        return savedKeyword.getId();
    }

    @GetMapping("")
    public List<Keyword> selectKeywords() {
        List<Keyword> selectedKeywords = keywordSvc.selectKeywords();
        return selectedKeywords;
    }

    @GetMapping("/{id}")
    public Keyword selectKeyword(@PathVariable Long id) {
        Keyword selectedKeyword = keywordSvc.selectKeyword(id).orElseThrow();
        return selectedKeyword;
    }

    @PutMapping("/{id}")
    public Long updateKeyword(@RequestBody Keyword keyword) {
        Keyword updatedKeyword = keywordSvc.saveKeyword(keyword);
        return updatedKeyword.getId();
    }

    @DeleteMapping("/{id}")
    public Long deleteKeyword(@PathVariable Long id) {
        return keywordSvc.deleteKeyword(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}