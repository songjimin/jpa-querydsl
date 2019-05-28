package com.example.querydsl.demo.repository;

import javax.transaction.Transactional;

import com.example.querydsl.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM teacher", nativeQuery = true)
	int deleteAllBy();
}
