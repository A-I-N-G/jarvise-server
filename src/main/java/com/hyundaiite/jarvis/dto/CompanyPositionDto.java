package com.hyundaiite.jarvis.dto;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyPositionDto {

    private Long id;

    private CompanyDto companyDto;

    private PositionDto positionDto;

    private ArrayList<String> keywordList;

    private ArrayList<String> itemList;

    private ArrayList<KeywordDto> keywordDtoList;

    private ArrayList<ItemDto> itemDtoList;

}
