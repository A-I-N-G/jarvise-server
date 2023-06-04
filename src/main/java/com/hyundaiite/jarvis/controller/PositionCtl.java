package com.hyundaiite.jarvis.controller;

import com.hyundaiite.jarvis.dto.PositionDto;
import com.hyundaiite.jarvis.dto.PositionSaveDto;
import com.hyundaiite.jarvis.service.PositionSvc;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * filename    : PositionCtl.java
 * description : 직무 컨트롤러
 * author      : 김건영
 *
 * Date			  Author		  Description
 * -------------- --------------- --------------------
 * 2023-06-05     김건영			  신규 생성
 *
 * -------------- --------------- --------------------
 */
@RestController
public class PositionCtl {

    @Autowired
    private PositionSvc positionSvc;

    /**
     * 직무 등록
     * @author 김건영
     * @param positionName
     * @param keywordList
     * @param introduction
     * @param question1
     * @param question2
     * @return PositionSaveDto
     * @throws Exception
     */
    @PostMapping("/savePosition")
    public PositionSaveDto savePositionName(@RequestParam(value = "positionName", required = true) String positionName,
                                            @RequestParam(value = "keywordList", required = false) ArrayList<String> keywordList,
                                            @RequestParam(value = "introduction", required = false) String introduction,
                                            @RequestParam(value = "question1", required = false) String question1,
                                            @RequestParam(value = "question2", required = false) String question2) throws Exception {

        PositionSaveDto positionSaveDto = PositionSaveDto.builder()
                .name(positionName)
                .introduction(introduction)
                .build();

        positionSaveDto = positionSvc.savePosition(positionSaveDto);

        return positionSaveDto;

    }

    /**
     * 직무 업데이트
     * @author 김건영
     * @param positionName
     * @param keywordList
     * @param introduction
     * @param question1
     * @param question2
     * @return PositionSaveDto
     * @throws Exception
     */
    @PutMapping("/updatePosition")
    public PositionSaveDto updatePositionName(@RequestParam(value = "positionId", required = true) Long positionId,
                                            @RequestParam(value = "positionName", required = true) String positionName,
                                            @RequestParam(value = "keywordList", required = false) ArrayList<String> keywordList,
                                            @RequestParam(value = "introduction", required = false) String introduction,
                                            @RequestParam(value = "question1", required = false) String question1,
                                            @RequestParam(value = "question2", required = false) String question2) throws Exception {

        PositionSaveDto positionSaveDto = PositionSaveDto.builder()
                .id(positionId)
                .name(positionName)
                .introduction(introduction)
                .build();

        positionSaveDto = positionSvc.updatePosition(positionSaveDto);

        return positionSaveDto;

    }

    /**
     * 직무 상세 조회
     * @author 김건영
     * @param positionId
     * @return PositionDto
     * @throws Exception
     */
    @GetMapping("/position/{positionId}")
    public PositionDto getPosition(@PathVariable Long positionId) throws Exception {

        PositionDto positionDto = PositionDto.builder().id(positionId).build();
        positionDto = positionSvc.getPosition(positionDto);

        return positionDto;

    }

    /**
     * 직무 리스트 조회
     * @author 김건영
     * @param
     * @return List<PositionDto>
     * @throws Exception
     */
    @GetMapping("/positions")
    public List<PositionDto> getPositions() throws Exception {

        List<PositionDto> positionDtos = positionSvc.getPositions();

        return positionDtos;

    }

}
