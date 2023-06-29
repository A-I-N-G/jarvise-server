package com.hyundaiite.jarvis.controller;

import com.hyundaiite.jarvis.entity.Apply;
import com.hyundaiite.jarvis.entity.CoverLetterItem;
import com.hyundaiite.jarvis.entity.CoverLetterItemKeyword;
import com.hyundaiite.jarvis.entity.Summary;
import com.hyundaiite.jarvis.service.ApplySvc;
import com.hyundaiite.jarvis.service.CoverLetterItemKeywordSvc;
import com.hyundaiite.jarvis.service.CoverLetterItemSvc;
import com.hyundaiite.jarvis.service.SummarySvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/applies")
public class ApplyCtl {

    @Autowired
    private ApplySvc applySvc;

    @Autowired
    private CoverLetterItemSvc coverLetterItemSvc;

    @Autowired
    private CoverLetterItemKeywordSvc coverLetterItemKeywordSvc;

    @Autowired
    private SummarySvc summarySvc;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveApply(@RequestBody Apply apply) {
        Apply savedApply = applySvc.saveApply(apply);
        return savedApply.getId();
    }

    @GetMapping("/{id}")
    public Apply selectApply(@PathVariable Long id) {
        Apply selectedApply = applySvc.selectApply(id).orElseThrow();
        return selectedApply;
    }

    @PostMapping("/{apply_id}/cover-letters/{cover_letter_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CoverLetterItem saveCoverLetterItem(@PathVariable Long apply_id, @PathVariable Long cover_letter_id, @RequestBody CoverLetterItem coverLetterItem) {
        CoverLetterItem savedCoverLetterItem = coverLetterItemSvc.saveCoverLetterItem(coverLetterItem);
        return savedCoverLetterItem;
    }

    @GetMapping("/{apply_id}/keywords/{keyword_id}/score")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<CoverLetterItemKeyword> selectCoverLetterItemKeyword(@PathVariable Long apply_id, @PathVariable Long keyword_id) throws Exception {
        ArrayList<CoverLetterItemKeyword> selectedCoverLetterItemKeyword = coverLetterItemKeywordSvc.selectCoverLetterItemKeyword(apply_id, keyword_id);
        return selectedCoverLetterItemKeyword;
    }

    @GetMapping("/{apply_id}/summary")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<Summary> selectSummary(@PathVariable Long apply_id) throws Exception {
        ArrayList<Summary> selectedSummary = summarySvc.selectSummary(apply_id);
        return selectedSummary;
    }

    @GetMapping("/{apply_id}/score")
    @ResponseStatus(HttpStatus.OK)
    public Double selectPositionScore(@PathVariable Long apply_id) {
        Double score = applySvc.selectPositionScore(apply_id);
        return score;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
