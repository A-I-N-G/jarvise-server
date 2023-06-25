package com.hyundaiite.jarvis.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Builder
public class CompanyPositionKeywordDto {

    private Long id;

    private CompanyPositionDto companyPositionDto;

    private KeywordDto keywordDto;

    private Double point;

}
