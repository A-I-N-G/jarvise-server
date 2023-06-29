package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.entity.Apply;
import com.hyundaiite.jarvis.entity.CoverLetter;
import com.hyundaiite.jarvis.entity.CoverLetterItem;
import com.hyundaiite.jarvis.entity.CoverLetterItemKeyword;
import com.hyundaiite.jarvis.repository.ApplyRepo;
import com.hyundaiite.jarvis.repository.CoverLetterItemKeywordRepo;
import com.hyundaiite.jarvis.repository.CoverLetterItemRepo;
import com.hyundaiite.jarvis.repository.CoverLetterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CoverLetterItemKeywordSvc {

    @Autowired
    private CoverLetterItemKeywordRepo coverLetterItemKeywordRepo;

    @Autowired
    private ApplyRepo applyRepo;

    @Autowired
    private CoverLetterRepo coverLetterRepo;

    @Autowired
    private CoverLetterItemRepo coverLetterItemRepo;

    public ArrayList<CoverLetterItemKeyword> selectCoverLetterItemKeyword(Long applyId, Long keywordId) throws Exception{
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

        ArrayList<CoverLetterItemKeyword> coverLetterItemKeywords = new ArrayList<>();

        for(CoverLetterItem coverLetterItem : coverLetterItems) {
            Long coverLetterItemId = coverLetterItem.getId();
            Optional<CoverLetterItemKeyword> coverLetterItemKeywordOptional = coverLetterItemKeywordRepo.findByCoverLetterItemIdAndKeywordId(coverLetterItemId, keywordId);
            if(!coverLetterItemKeywordOptional.isEmpty()) {
                coverLetterItemKeywords.add(coverLetterItemKeywordOptional.get());
            }
        }

        return coverLetterItemKeywords;
    }

}
