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
public class CoverLetterItem {

    @Id
    @Column(name = "cover_letter_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "cover_letter_id", nullable = false)
    @ManyToOne(targetEntity = CoverLetter.class, fetch = FetchType.LAZY)
    private CoverLetter coverLetter;

    @JoinColumn(name = "item_id", nullable = false)
    @ManyToOne(targetEntity = Item.class, fetch = FetchType.LAZY)
    private Item item;

    private String answer;
}
