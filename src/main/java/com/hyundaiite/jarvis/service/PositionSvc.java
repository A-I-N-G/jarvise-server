package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.entity.CompanyPosition;
import com.hyundaiite.jarvis.entity.Position;
import com.hyundaiite.jarvis.repository.CompanyPositionRepo;
import com.hyundaiite.jarvis.repository.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * filename    : PositionSvc.java
 * description : 채용 서비스
 * author      : 김건영
 *
 * Date			  Author		  Description
 * -------------- --------------- --------------------
 * 2023-07-01     김건영			  신규 생성
 *
 * -------------- --------------- --------------------
 */

@Service
public class PositionSvc {

    @Autowired
    private PositionRepo positionRepo;

    @Autowired
    private CompanyPositionRepo companyPositionRepo;

    public Position savePosition(Position position) {
        return positionRepo.save(position);
    }

    public ArrayList<Position> selectPositions(CompanyPosition companyPosition) {
        ArrayList<CompanyPosition> companyPositions = companyPositionRepo.findByCompany(companyPosition.getCompany());

        ArrayList<Position> selectedPositions = new ArrayList<>();

        for(CompanyPosition entity : companyPositions) {
            Position position = entity.getPosition();
            selectedPositions.add(position);
        }

        return selectedPositions;
    }


    public Position selectPosition(String name) {
        Position selectedPosition = Position.builder()
                .name(name)
                .build();

        selectedPosition = positionRepo.findByName(name);

        return selectedPosition;

    }

    public Position updatePosition(Position position) {

        return positionRepo.save(position);

    }

}
