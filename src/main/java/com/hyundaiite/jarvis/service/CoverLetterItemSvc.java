package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.entity.CoverLetterItem;
import com.hyundaiite.jarvis.repository.CoverLetterItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoverLetterItemSvc {

    @Autowired
    private CoverLetterItemRepo coverLetterItemRepo;

    public CoverLetterItem saveCoverLetterItem(CoverLetterItem coverLetterItem) {
        return coverLetterItemRepo.save(coverLetterItem);
    }

}
