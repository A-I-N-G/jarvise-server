package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.entity.Apply;
import com.hyundaiite.jarvis.repository.ApplyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplySvc {

    @Autowired
    private ApplyRepo applyRepo;

    public Apply saveApply(Apply apply) {
        return applyRepo.save(apply);
    }


    public Optional<Apply> selectApply(Long id) {
        return applyRepo.findById(id);
    }

    public Double selectPositionScore(Long applyId) {
        //TODO
        Double score = 0.0;
        return score;
    }

}
