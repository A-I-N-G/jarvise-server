package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.dto.PositionDto;
import com.hyundaiite.jarvis.dto.PositionSaveDto;
import com.hyundaiite.jarvis.entity.Position;
import com.hyundaiite.jarvis.repository.PositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * filename    : PositionSvc.java
 * description : 직무 서비스
 * author      : 김건영
 *
 * Date			  Author		  Description
 * -------------- --------------- --------------------
 * 2023-06-05     김건영			  신규 생성
 *
 * -------------- --------------- --------------------
 */
@Service
public class PositionSvc {

    @Autowired
    private PositionRepo positionRepo;

    public PositionSaveDto savePosition(PositionSaveDto positionSaveDto) throws Exception {

        Position positionEntity = Position.builder()
                .name(positionSaveDto.getName())
                .introduction(positionSaveDto.getIntroduction())
                .build();

        positionEntity = positionRepo.save(positionEntity);

        PositionSaveDto rtn = PositionSaveDto.builder()
                .id(positionEntity.getId())
                .name(positionEntity.getName())
                .introduction(positionEntity.getIntroduction())
                .build();

        return rtn;

    }

    public PositionSaveDto updatePosition(PositionSaveDto positionSaveDto) throws Exception {

        Position positionEntity = positionRepo.findById(positionSaveDto.getId()).get();

        if(positionEntity == null) {
            throw new Exception("존재하지 않는 직무입니다.");
        }

        positionEntity = Position.builder()
                .id(positionSaveDto.getId())
                .name(positionSaveDto.getName())
                .introduction(positionSaveDto.getIntroduction())
                .build();

        positionEntity = positionRepo.save(positionEntity);

        PositionSaveDto rtn = PositionSaveDto.builder()
                .id(positionEntity.getId())
                .name(positionEntity.getName())
                .introduction(positionEntity.getIntroduction())
                .build();

        return rtn;

    }

    public PositionDto getPosition(PositionDto positionDto) throws Exception {

        Optional<Position> positionEntityOpt = positionRepo.findById(positionDto.getId());

        if(positionEntityOpt.isEmpty()) {
            throw new Exception("존재하지 않는 직무입니다.");
        }

        Position positionEntity = positionEntityOpt.get();

        PositionDto rtn = PositionDto.builder()
                .id(positionEntity.getId())
                .name(positionEntity.getName())
                .introduction(positionEntity.getIntroduction())
                .build();

        return rtn;

    }

    public List<PositionDto> getPositions() {

        List<Position> positionEntities = positionRepo.findAll();
        List<PositionDto> positionDtos = new ArrayList<>();

        PositionDto positionDto = null;
        for(Position position : positionEntities) {
            positionDto = PositionDto.builder()
                    .id(position.getId())
                    .name(position.getName())
                    .introduction(position.getIntroduction())
                    .build();

            positionDtos.add(positionDto);
        }

        return positionDtos;
    }
}
