package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.entity.*;
import com.hyundaiite.jarvis.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SummarySvc {

    @Autowired
    private SummaryRepo summaryRepo;

    @Autowired
    private ApplyRepo applyRepo;

    @Autowired
    private CoverLetterRepo coverLetterRepo;

    @Autowired
    private CoverLetterItemRepo coverLetterItemRepo;

    public ArrayList<Summary> selectSummary(Long applyId) throws Exception {

        Optional<Apply> applyOptional = applyRepo.findById(applyId);

        if(applyOptional.isEmpty()) {
            throw new Exception("지원 정보가 존재하지 않습니다.");
        }

        Optional<CoverLetter> coverLetterOptional = coverLetterRepo.findByApplyId(applyOptional.get().getId());

        if(coverLetterOptional.isEmpty()) {
            throw new Exception("자기소개서가 존재하지 않습니다.");
        }

        ArrayList<CoverLetterItem> coverLetterItems = coverLetterItemRepo.findByCoverLetterId(coverLetterOptional.get().getId());

        if(coverLetterItems.size() == 0) {
            throw new Exception("자기소개서 항목이 존재하지 않습니다.");
        }

        ArrayList<Summary> summaries = new ArrayList<>();

        for(CoverLetterItem coverLetterItem : coverLetterItems) {
            Long coverLetterItemId = coverLetterItem.getCoverLetter().getId();
            Summary summary = summaryRepo.findByCoverLetterItemIdAndApplyId(coverLetterItemId, applyId);
            summaries.add(summary);
        }

        return summaries;

    }

}
