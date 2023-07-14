package com.hyundaiite.jarvis.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
public class CompanyPositionItem {

    @Id
    @Column(name = "compony_position_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "company_position_id", nullable = false)
    @ManyToOne(targetEntity = CompanyPosition.class, fetch = FetchType.LAZY)
    private CompanyPosition companyPosition;

    @JoinColumn(name = "item_id", nullable = false)
    @ManyToOne(targetEntity = Item.class, fetch = FetchType.EAGER)
    private Item item;

}
