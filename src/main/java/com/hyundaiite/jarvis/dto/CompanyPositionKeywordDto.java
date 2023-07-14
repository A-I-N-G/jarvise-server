package com.hyundaiite.jarvis.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class CompanyPositionKeywordDto {

    private Long companPositionId;

    private Long companyId;

    private Long positionId;

    private String name;

    private String introduction;

    private ArrayList<String> keywordList;

}
