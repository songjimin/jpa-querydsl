package com.example.querydsl.demo.test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import com.example.querydsl.demo.model.Academy;
import com.example.querydsl.demo.model.AcademyTeacher;
import com.example.querydsl.demo.model.Teacher;
import com.example.querydsl.demo.repository.AcademyRepository;
import com.example.querydsl.demo.repository.TeacherRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JoinTest {

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private AcademyRepository academyRepository;

	@After
	public void clean() {
		academyRepository.deleteAllBy();
		teacherRepository.deleteAllBy();
	}


	@Test
	public void Join_관계X() {

		String academyName = "name";
		academyRepository.saveAll(Arrays.asList(
				new Academy(academyName, ""),
				new Academy("not target", "")
		));

		String teacherName = "teacher";
		teacherRepository.save(new Teacher(teacherName, "Java", 1L));

		List<Academy> academyList = academyRepository.findAll();
		List<Teacher> teacherList = teacherRepository.findAll();

		//when
		List<AcademyTeacher> academyTeachers = academyRepository.findAllAcademyTeacher();

		//then
		assertThat(academyTeachers.size(), is(1));
		assertThat(academyTeachers.get(0).getAcademyName(), is(academyName));
		assertThat(academyTeachers.get(0).getTeacherName(), is(teacherName));
	}
}
