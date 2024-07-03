package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

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
	
	// update
	// input: id, dreamjob
	// output: updated StudentEntity or null
	public StudentEntity updateStudentDreamjobById(int id, String dreamjob) {
		// 기존 데이터 조회 => StudentEntity
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// 엔티티의 데이터 값을 변경해놓는다.
		if (student != null) {
			student = student.toBuilder() //toBuilder는 기존 필드값은 유지하고 일부만 변경 가능
					.dreamjob(dreamjob)
					.build(); // 꼭 객체에 다시 저장!
			
			// update
			// save 요청
			student = studentRepository.save(student);
		}
		return student;
	}
	
	// input: id
	// output: void
	public void deleteStudentById(int id) {
		// 방법1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방번2)
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
	}
}
