package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.vo.TestVo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TestRepo extends JpaRepository<TestVo, Long> {

    public Optional<TestVo> findById(Long id);

    public List<TestVo> findByColor(String color);

    public List<TestVo> findByColorLike(String color);


}
