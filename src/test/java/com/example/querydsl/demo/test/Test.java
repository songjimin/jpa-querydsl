package com.example.querydsl.demo.test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import com.example.querydsl.demo.model.Academy;
import com.example.querydsl.demo.repository.AcademyRepository;
import com.example.querydsl.demo.repository.AcademyRepositoryCustom;
import org.junit.After;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

	@Autowired
	private AcademyRepository academyRepository;

	@After
	public void deleteAll() {
		academyRepository.deleteAll();
	}

	@org.junit.Test
	public void query_dsl_테스트() {

		String name = "TestUser";
		String address = "testUser@test.com";

		academyRepository.save(new Academy(name, address));

		List<Academy> testResult = academyRepository.findByName(name);

		assertThat(testResult.size(), is(1));
		assertNotNull(testResult.get(0).getAddress(), is(address));

	}
}
