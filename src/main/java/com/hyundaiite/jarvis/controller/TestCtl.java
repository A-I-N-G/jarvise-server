package com.hyundaiite.jarvis.controller;

import com.hyundaiite.jarvis.service.TestSvc;
import com.hyundaiite.jarvis.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("test")
public class TestCtl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestSvc testSvc;

    @GetMapping("/")
    public void testClt() {
        logger.info("result :: 컨트롤러단 테스트");
        testSvc.testSvc();
    }

    // 모든 객체 조회
    @GetMapping(value = "/All", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<TestVo>> getAllTestVos() {
        List<TestVo> members = testSvc.findAll();
        return new ResponseEntity<List<TestVo>>(members, HttpStatus.OK);
    }

    // id로 하나의 객체 조회
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<TestVo> getMember(@PathVariable("id") Long id) {
        Optional<TestVo> member = testSvc.findById(id);
        return new ResponseEntity<TestVo>(member.get(), HttpStatus.OK);
    }

    // id로 객 삭제
    @DeleteMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> deleteMember(@PathVariable("id") Long id) {
        testSvc.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // id로 객체 수정
    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<TestVo> updateMember(@PathVariable("id") Long id, TestVo testVo) {
        testSvc.updateById(id, testVo);
        return new ResponseEntity<TestVo>(testVo, HttpStatus.OK);
    }

    // 객체 저장
    @PostMapping(value="/saveTest")
    public ResponseEntity<TestVo> save(HttpServletRequest req, TestVo testVo){
        return new ResponseEntity<TestVo>(testSvc.save(testVo), HttpStatus.OK);
    }

}
