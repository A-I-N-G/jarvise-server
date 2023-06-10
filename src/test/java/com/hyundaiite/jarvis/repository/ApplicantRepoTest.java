package com.hyundaiite.jarvis.repository;

import com.hyundaiite.jarvis.common.enums.Gender;
import com.hyundaiite.jarvis.entity.Applicant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApplicantRepoTest {
    @Autowired
    ApplicantRepo applicantRepo;

    @BeforeEach
    void insertTestData() {
        Applicant applicant = Applicant.builder()
                .name("홍길동")
                .birthday(new Date())
                .gender(Gender.MALE)
                .build();

        applicantRepo.save(applicant);
    }

    @Test
    void saveTest() {
        // then
        assertEquals(applicantRepo.count(), 1);
    }

    @Test
    void findByIdTest() {
        // given
        List<Applicant> applicant = applicantRepo.findAll();
        Long id = applicant.get(0).getId();

        // when
        Optional<Applicant> applicant1 = applicantRepo.findById(id);

        // then
        assertThat(applicant.get(0)).isEqualTo(applicant1.get());
    }

    @Test
    void updateTest() {
        // given
        Applicant applicant = applicantRepo.findAll().get(0);
        applicant.setName("홍길동전");

        // when
        applicantRepo.save(applicant);

        // then
        assertThat(applicant.getName()).isEqualTo(applicantRepo.findAll().get(0).getName());
    }

    @Test
    void deleteTest() {
        // given
        List<Applicant> applicant = applicantRepo.findAll();

        // when
        applicantRepo.delete(applicant.get(0));

        // then
        assertThat(applicantRepo.count()).isEqualTo(0);
    }


}
