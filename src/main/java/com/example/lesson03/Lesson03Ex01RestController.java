package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex01?id=7
	
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id // 필수 파라미터
			// @RequestParam(value = "id") int id // 필수 파라미터
			// @RequestParam(value = "id", required = true) int id // 필수라고 강조하는거 
			// @RequestParam(value = "id", required = false) Integer id // 비필수라고 하는법 Integer 이어야 null 가능
			// @RequestParam(value = "id", defaultValue = "1") int id // 업으면 기본값 1로 설정 if 문 안써도 됨
			) {
		
//		if (id == null) {
//			id = 1;
//		}
		
		return reviewBO.getReviewById(id);
	}
}
