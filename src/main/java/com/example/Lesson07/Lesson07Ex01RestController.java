package com.example.Lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Lesson07.entity.StudentEntity;
import com.example.lesson04.bo.StudentBO;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// C: create
	@GetMapping("/create")
	public StudentEntity create() {
		String name = "박민철";
		String phoneNumber = "010-2525-1119";
		String email = "beeyoong@gmail.com";
		String dreamjob = "경찰";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamjob);
		
	}
}
