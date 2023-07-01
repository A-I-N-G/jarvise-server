package com.hyundaiite.jarvis.controller;

import com.hyundaiite.jarvis.dto.*;
import com.hyundaiite.jarvis.service.JobPostingSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * filename    : JobPostingCtl.java
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
public class JobPostingCtl {

    @Autowired
    private JobPostingSvc positionSvc;

    /**
     * 직무 등록
     * @author 김건영
     * @param companyPositionDto
     * @return PositionSaveDto
     * @throws Exception
     */
    @PostMapping("/job-posting")
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyPositionDto saveJobPosting(@RequestBody CompanyPositionDto companyPositionDto) throws Exception {

        companyPositionDto = positionSvc.saveJobPosting(companyPositionDto);

        return companyPositionDto;

    }

}