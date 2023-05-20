package com.hyundaiite.jarvis.service;

import com.hyundaiite.jarvis.repository.TestRepo;
import com.hyundaiite.jarvis.vo.TestVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TestSvc {

    @Autowired
    private TestRepo testRepo;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void testSvc() {
        logger.info("result :: 서비스단 테스트");
    }

    public List<TestVo> findAll() {
        List<TestVo> testVos = new ArrayList<>();
        testRepo.findAll().forEach(e -> {
            testVos.add(e);
            logger.info(e.toString());
        });
        return testVos;
    }

    public Optional<TestVo> findById(Long id){
        Optional<TestVo> testVo = testRepo.findById(id);
        return testVo;
    }

    public void deleteById(Long id) {
        testRepo.deleteById(id);
    }

    public void updateById(Long id, TestVo testVo) {
        Optional<TestVo> e = testRepo.findById(id);

        if (e.isPresent()) {
//            e.get().setId(testVo.getId());
            e.get().setColor(testVo.getColor());
            e.get().setSize(testVo.getSize());
            testRepo.save(testVo);
        }
    }

    public TestVo save(TestVo testVo) {
        testRepo.save(testVo);
        return testVo;
    }

}
