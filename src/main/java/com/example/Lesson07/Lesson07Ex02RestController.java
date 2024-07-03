package com.example.Lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lesson07.entity.StudentEntity;
import com.example.Lesson07.repository.StudentRepository;

@RequestMapping("/lesson07/ex02")
@RestController
public class Lesson07Ex02RestController {

	
	// !!!!! 이번에만 BO 생략
	@Autowired
	private StudentRepository studentRepository;
	
	// 조회하는 다양한 방법
	@GetMapping("/select1")
	public List<StudentEntity> select1() {
		// 1) 전채조회 (기본으로 제공됨)
		// return studentRepository.findAll();
		
		// 2) id 기준 내림차순 전체 조회
		// return studentRepository.findAllByOrderByIdDesc();
		
		// 3) id 기준 내림차순 3개만 조회
		// return studentRepository.findTop3ByOrderByIdDesc();
		
		// 4) 이름이 Michael인 데이터 조회
		// return studentRepository.findByName("Michael");
		
		// 5) in문으로 일치하는 값 모두 조회
		// return studentRepository.findByNameIn(List.of("유재석", "Michael"));
		
		// 6) 여러 컬럼값과 일치하는 데이터 조회
		// return studentRepository.findByNameAndDreamjob("박민철", "축구선수");
		
		// 7) email 컬럼에 gmail이 포함된 데이터 조회 like '%gmail%'
		// return studentRepository.findByEmailContains("gmail");
		
		// 8) M으로 시작하는 데이터조회
		// return studentRepository.findByNameStartingWith("M");
		
		// 9) id가 2~6까지 조회
		return studentRepository.findByIdBetween(2, 6);
	}
}
