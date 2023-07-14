package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.dto.*;
import com.hyundaiite.jarvis.entity.*;
import com.hyundaiite.jarvis.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * filename    : JobPostingSvc.java
 * description : 채용 서비스
 * author      : 김건영
 *
 * Date			  Author		  Description
 * -------------- --------------- --------------------
 * 2023-06-18     김건영			  신규 생성
 *
 * -------------- --------------- --------------------
 */

@Service
public class JobPostingSvc {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CompanyRepo companyRepo;

    @Autowired
    PositionRepo positionRepo;

    @Autowired
    CompanyPositionRepo companyPositionRepo;

    @Autowired
    KeywordRepo keywordRepo;

    @Autowired
    CompanyPositionKeywordRepo companyPositionKeywordRepo;

    @Autowired
    ItemRepo itemRepo;

    @Autowired
    CompanyPositionItemRepo companyPositionItemRepo;

    public CompanyPositionDto saveJobPosting(CompanyPositionDto companyPositionDto) throws Exception{

        Optional<Company> companyOptional = companyRepo.findById(companyPositionDto.getCompanyDto().getId());

        if(companyOptional.isEmpty()) {
            throw new Exception("존재하지 않는 회사입니다.");
        }

        Optional<Position> positionOptional = positionRepo.findById(companyPositionDto.getPositionDto().getId());

        // 직무가 존재하지 않으면 insert
        if(positionOptional.isEmpty()) {
            Position positionEntity = Position.builder()
                    .name(companyPositionDto.getPositionDto().getName())
                    .introduction(companyPositionDto.getPositionDto().getIntroduction())
                    .build();
            positionOptional = Optional.of(positionRepo.save(positionEntity));
        }

        Optional<CompanyPosition> companyPositionOptional = companyPositionRepo.findByCompanyIdAndPositionId(
                companyPositionDto.getCompanyDto().getId(), companyPositionDto.getPositionDto().getId()
        );

        // 회사-직무 존재하지 않으면 insert
        if(companyPositionOptional.isEmpty()) {
            CompanyPosition companyPositionEntity = CompanyPosition.builder()
                    .company(companyOptional.get())
                    .position(positionOptional.get())
                    .build();
            companyPositionOptional = Optional.of(companyPositionRepo.save(companyPositionEntity));
        }

        ArrayList<String> keywordList = companyPositionDto.getKeywordList();

        // 키워드 개수만큼 반복
        for(String name : keywordList) {

            Optional<Keyword> keywordOptional = keywordRepo.findByName(name);
            // 키워드가 존재하지 않으면 insert
            if(keywordOptional.isEmpty()) {
                Keyword keyword = Keyword.builder()
                        .name(name)
                        .build();
                keywordOptional = Optional.of(keywordRepo.save(keyword));
            }

            Optional<CompanyPositionKeyword> companyPositionKeywordOptional = companyPositionKeywordRepo.findByCompanyPositionIdAndKeywordId(
                    companyPositionOptional.get().getId(), keywordOptional.get().getId()
            );

            // 회사직무키워드 존재하지 않으면 insert
            if(companyPositionKeywordOptional.isEmpty()) {
                CompanyPositionKeyword companyPositionKeyword = CompanyPositionKeyword.builder()
                        .companyPosition(companyPositionOptional.get())
                        .keyword(keywordOptional.get())
                        .build();
                companyPositionKeywordOptional = Optional.of(companyPositionKeywordRepo.save(companyPositionKeyword));
            }

        }

        ArrayList<String> contentList = companyPositionDto.getItemList();
        // 질문 개수만큼 반복
        for(String content : contentList) {

            Optional<Item> itemOptional = itemRepo.findByContent(content);
            // 항목이 존재하지 않으면 insert
            if(itemOptional.isEmpty()) {
                Item item = Item.builder()
                        .content(content)
                        .build();
                itemOptional = Optional.of(itemRepo.save(item));
            }

            Optional<CompanyPositionItem> companyPositionItemOptional = companyPositionItemRepo.findByCompanyPositionIdAndItemId(
                companyPositionOptional.get().getId(), itemOptional.get().getId()
            );
            // 회사직무항목이 존재하지 않으면 insert
            if(companyPositionItemOptional.isEmpty()) {
                CompanyPositionItem companyPositionItem = CompanyPositionItem.builder()
                        .companyPosition(companyPositionOptional.get())
                        .item(itemOptional.get())
                        .build();

                companyPositionItemOptional = Optional.of(companyPositionItemRepo.save(companyPositionItem));
            }

        }

        // return 세팅

        CompanyDto companyDto = CompanyDto.builder()
                .id(companyOptional.get().getId())
                .name(companyOptional.get().getName())
                .build();

        PositionDto positionDto = PositionDto.builder()
                .id(positionOptional.get().getId())
                .name(positionOptional.get().getName())
                .introduction(positionOptional.get().getIntroduction())
                .build();

        ArrayList<KeywordDto> keywordDtos = new ArrayList<>();
        ArrayList<CompanyPositionKeyword> companyPositionKeywords = companyPositionKeywordRepo.findByCompanyPositionId(companyPositionOptional.get().getId());
        for(CompanyPositionKeyword entity : companyPositionKeywords) {
            Keyword keyword = entity.getKeyword();
            KeywordDto keywordDto = KeywordDto.builder()
                    .id(keyword.getId())
                    .name(keyword.getName())
                    .build();
            keywordDtos.add(keywordDto);
        }

        ArrayList<ItemDto> itemDtos = new ArrayList<>();
        ArrayList<CompanyPositionItem> companyPositionItems = companyPositionItemRepo.findByCompanyPositionId(companyPositionOptional.get().getId());
        for(CompanyPositionItem entity : companyPositionItems) {
            Item item = entity.getItem();
            ItemDto itemDto = ItemDto.builder()
                    .id(item.getId())
                    .content(item.getContent())
                    .build();
            itemDtos.add(itemDto);
        }

        companyPositionDto = CompanyPositionDto.builder()
                .companyDto(companyDto)
                .positionDto(positionDto)
                .keywordDtoList(keywordDtos)
                .itemDtoList(itemDtos)
                .build();

        return companyPositionDto;

    }

    public ArrayList<CompanyPositionKeywordDto> selectJobPostings() {

        ArrayList<CompanyPositionKeywordDto> companyPositionKeywordDtos = new ArrayList<>();

        List<CompanyPosition> companyPositions = companyPositionRepo.findAll();

        for(CompanyPosition entity : companyPositions) {
            CompanyPositionKeywordDto dto = CompanyPositionKeywordDto.builder()
                    .companPositionId(entity.getId())
                    .companyId(entity.getCompany().getId())
                    .positionId(entity.getPosition().getId())
                    .build();
            companyPositionKeywordDtos.add(dto);
        }

        for(CompanyPositionKeywordDto dto : companyPositionKeywordDtos) {
            Long positionId = dto.getPositionId();

            Optional<Position> position = positionRepo.findById(positionId);
            if(!position.isEmpty()) {
                dto.setName(position.get().getName());
                dto.setIntroduction(position.get().getIntroduction());
            }

            Long companyPositionId = dto.getCompanPositionId();
            List<CompanyPositionKeyword> companyPositionKeywords = companyPositionKeywordRepo.findByCompanyPositionId(companyPositionId);
            ArrayList<String> keywordList = new ArrayList<>();
            for(CompanyPositionKeyword entity : companyPositionKeywords) {
                Keyword keyword = entity.getKeyword();
                keywordList.add(keyword.getName());
            }

            dto.setKeywordList(keywordList);
        }

        return companyPositionKeywordDtos;

    }

}
