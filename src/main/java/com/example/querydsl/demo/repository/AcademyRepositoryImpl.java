package com.example.querydsl.demo.repository;

import static com.example.querydsl.demo.model.QAcademy.academy;

import java.util.List;

import com.example.querydsl.demo.model.Academy;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@RequiredArgsConstructor
public class AcademyRepositoryImpl implements AcademyRepositoryCustom {
	/**
	 * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
	 *
	 * @param domainClass must not be {@literal null}.
	 */
	private final JPAQueryFactory queryFactory;

	public List<Academy> findByName(String name) {
		return  queryFactory.selectFrom(academy)
							.where(academy.name.eq(name))
							.fetch();
	}
}
