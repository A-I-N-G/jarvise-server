package com.hyundaiite.jarvis.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Summary {
    @Id
    @Column(name = "summary_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "cover_letter_id", nullable = false)
    @ManyToOne(targetEntity = CoverLetterItem.class, fetch = FetchType.LAZY)
    private CoverLetterItem coverLetterItem;

    private String content;

    private String strength;

    private String weakness;
}
