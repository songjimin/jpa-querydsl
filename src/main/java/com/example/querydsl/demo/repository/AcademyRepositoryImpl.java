package com.example.querydsl.demo.repository;

import static com.querydsl.core.types.ExpressionUtils.count;

import java.util.List;

import com.example.querydsl.demo.model.Academy;
import com.example.querydsl.demo.model.QAcademy;
import com.example.querydsl.demo.model.QStudent;
import com.example.querydsl.demo.model.StudentCount;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class AcademyRepositoryImpl extends QuerydslRepositorySupport implements AcademyRepositoryCustom {

	public AcademyRepositoryImpl() {
		super(Academy.class);
	}

	public List<Academy> findByName(String name) {
		QAcademy academy = QAcademy.academy;
		return from(academy)
				.where(academy.name.eq(name))
				.fetch();
	}

	public Page<Academy> findByName(String name, Pageable pageable) {

		QAcademy academy = QAcademy.academy;
		QueryResults<Academy> accountSearchResults = from(academy)
														.where(academy.name.eq(name))
														.limit(pageable.getPageSize())
														.offset(pageable.getOffset()).fetchResults();

		return new PageImpl<>(accountSearchResults.getResults(), pageable, accountSearchResults.getTotal());
	}


	public List<StudentCount> findAllStudentCount() {

		QAcademy academy = QAcademy.academy;
		QStudent student = QStudent.student;

		return from(academy).select(Projections.fields(StudentCount.class, academy.name.as("academyName"),
									ExpressionUtils.as(
											JPAExpressions.select(count(student.Id))
															.from(student)
															.where(student.academy.eq(academy)), "studentCount")
									))
									.from(academy).fetch();
	}

}
