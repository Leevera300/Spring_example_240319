package com.example.Lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Lesson07.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	
	// Spring Data JPA vs 순수 JPA
	// save = insert
	// public StudentEntity save(StudentEntity student) 
	// public StudentEntity findById(int id)
	// public void delete(StudentEntity student)
	// public List<StudentEntity> findAll()
	
	// ex02/select1 - JPQL 문법
	public List<StudentEntity> findAllByOrderByIdDesc();
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	public List<StudentEntity> findByName(String name);
	public List<StudentEntity> findByNameIn(List<String> names);
	public List<StudentEntity> findByNameAndDreamjob(String name, String dreamjob);
	public List<StudentEntity> findByEmailContains(String keyword);
	public List<StudentEntity> findByNameStartingWith(String keyword);
	public List<StudentEntity> findByIdBetween(int start, int end);
}
