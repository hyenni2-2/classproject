package com.mw.closet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mw.closet.domain.Closet;
import com.mw.closet.domain.Codi;
import com.mw.closet.service.CodiService;

@RestController
@RequestMapping("/codi")
public class CodiController {
	
	@Autowired
	CodiService codi;
	
	
	@GetMapping
	@CrossOrigin
	public List<Codi> getCodi(
			){
	    return codi.getCodiList();
	}

}
