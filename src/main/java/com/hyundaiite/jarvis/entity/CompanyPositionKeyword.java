package com.hyundaiite.jarvis.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class CompanyPositionKeyword {
    @Id
    @Column(name = "company_position_keyword_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "company_position_id", nullable = false)
    @ManyToOne(targetEntity = CompanyPosition.class, fetch = FetchType.LAZY)
    private CompanyPosition companyPosition;

    @JoinColumn(name = "keyword_id", nullable = false)
    @ManyToOne(targetEntity = Keyword.class, fetch = FetchType.LAZY)
    private Keyword keyword;

    private Double point;
}
