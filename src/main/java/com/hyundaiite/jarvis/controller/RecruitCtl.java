package com.hyundaiite.jarvis.controller;

import com.hyundaiite.jarvis.dto.*;
import com.hyundaiite.jarvis.service.RecruitSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * filename    : RecruitCtl.java
 * description : 채용 컨트롤러
 * author      : 김건영
 *
 * Date			  Author		  Description
 * -------------- --------------- --------------------
 * 2023-06-18     김건영			  신규 생성
 *
 * -------------- --------------- --------------------
 */

@RestController
public class RecruitCtl {

    @Autowired
    private RecruitSvc recruitSvc;

    /**
     * 직무 등록
     * @author 김건영
     * @param positionName
     * @param keywordList
     * @param introduction
     * @param questionList
     * @return PositionSaveDto
     * @throws Exception
     */
    @PostMapping("/saveRecruit")
    public CompanyPositionDto saveRecruit(@RequestParam(value = "companyId", required = true) Long companyId,
                                          @RequestParam(value = "positionId", required = true) Long positionId,
                                          @RequestParam(value = "positionName", required = true) String positionName,
                                          @RequestParam(value = "keywordList", required = true) ArrayList<String> keywordList,
                                          @RequestParam(value = "introduction", required = true) String introduction,
                                          @RequestParam(value = "itemList", required = false) ArrayList<String> itemList) throws Exception {

        CompanyDto companyDto = CompanyDto.builder()
                .id(companyId)
                .build();

        PositionDto positionDto = PositionDto.builder()
                .id(positionId)
                .name(positionName)
                .introduction(introduction)
                .build();

        CompanyPositionDto companyPositionDto = CompanyPositionDto.builder()
                .companyDto(companyDto)
                .positionDto(positionDto)
                .keywordList(keywordList)
                .itemList(itemList)
                .build();

        companyPositionDto = recruitSvc.saveRecruit(companyPositionDto);

        return companyPositionDto;

    }

}
