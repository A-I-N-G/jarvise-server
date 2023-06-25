package com.hyundaiite.jarvis.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
public class KeywordDto {

    private Long id;

    private String name;

}
