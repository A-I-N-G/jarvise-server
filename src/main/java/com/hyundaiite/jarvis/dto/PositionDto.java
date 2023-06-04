package com.hyundaiite.jarvis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PositionDto {

    private Long id;

    private String name;

    private String introduction;

}
