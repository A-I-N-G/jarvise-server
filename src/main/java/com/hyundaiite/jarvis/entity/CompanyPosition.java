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
public class CompanyPosition {
    @Id
    @Column(name = "company_position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "company_id", nullable = false)
    @ManyToOne(targetEntity = Company.class, fetch = FetchType.LAZY)
    private Company company;

    @JoinColumn(name = "position_id", nullable = false)
    @ManyToOne(targetEntity = Position.class, fetch = FetchType.LAZY)
    private Position position;

}
