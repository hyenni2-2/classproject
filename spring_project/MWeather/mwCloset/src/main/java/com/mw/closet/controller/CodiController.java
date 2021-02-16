package com.mw.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mw.closet.domain.Codi;
import com.mw.closet.service.CodiService;

@RestController
@RequestMapping("/codi")
public class CodiController {
	
	@Autowired
	CodiService codi;
	
	// 대분류 카테고리 가져오기
		@GetMapping     // /closet/codi
		@CrossOrigin
		public List<Codi> getCodi(){
		    return codi.getCodiList();
		}
}
