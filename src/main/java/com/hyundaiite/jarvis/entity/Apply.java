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
public class Apply {

    @Id
    @Column(name = "apply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "applicant_id", nullable = false)
    @ManyToOne(targetEntity = Applicant.class, fetch = FetchType.LAZY)
    private Applicant applicant;

    @JoinColumn(name = "company_position_id", nullable = false)
    @ManyToOne(targetEntity = CompanyPosition.class, fetch = FetchType.LAZY)
    private CompanyPosition companyPosition;
}
