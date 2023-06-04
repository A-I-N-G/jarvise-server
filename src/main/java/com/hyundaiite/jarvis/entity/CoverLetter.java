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
public class CoverLetter {
    @Id
    @Column(name = "cover_letter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "apply_id", nullable = false)
    @ManyToOne(targetEntity = Apply.class, fetch = FetchType.LAZY)
    private Apply apply;
}
