package com.hyundaiite.jarvis.vo;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="test")
public class TestVo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String color;

    private String size;

    @Builder
    public TestVo(Long id, String color) {

        this.id = id;
        this.color = color;

    }
}
