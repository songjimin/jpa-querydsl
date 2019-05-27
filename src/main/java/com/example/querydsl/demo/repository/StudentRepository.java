package com.example.querydsl.demo.repository;

import javax.transaction.Transactional;

import com.example.querydsl.demo.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM student", nativeQuery = true)
	int deleteAllBy();
}
