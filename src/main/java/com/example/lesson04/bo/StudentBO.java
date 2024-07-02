package com.example.lesson04.bo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Lesson07.entity.StudentEntity;
import com.example.Lesson07.repository.StudentRepository;
import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// input: name, phoneNumber, email, dreamjob
	// output: StudentEntity
	public StudentEntity addStudent(String name, String phoneNumber, 
			String email, String dreamjob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamjob(dreamjob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 있으면 생략가능
				.build();
		
		return studentRepository.save(student);
	}
	
	// input: Student
	// output: X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// input: id
	// output: Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
}
