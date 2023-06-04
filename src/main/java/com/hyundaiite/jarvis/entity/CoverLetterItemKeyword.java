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
public class CoverLetterItemKeyword {
    @Id
    @Column(name = "cover_letter_item_keyword_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "cover_letter_item_id", nullable = false)
    @ManyToOne(targetEntity = CoverLetterItem.class, fetch = FetchType.LAZY)
    private CoverLetterItem coverLetterItem;

    @JoinColumn(name = "keyword_id", nullable = false)
    @ManyToOne(targetEntity = Keyword.class, fetch = FetchType.LAZY)
    private Keyword keyword;

    private Double score;
}
