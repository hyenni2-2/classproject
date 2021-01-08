package com.aia.firstspring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.firstspring.domain.SearchType;

@Controller
public class SearchController {
 
	@RequestMapping("/search/search") // searchTypeList와 queryList는 search안에서만 공유 가능함, 만약 밖으로 빼고 싶다면 아예 바깥으로 내야함
	public String search() {
		return "search/search";
	}
	
	@ModelAttribute("searchTypeList") // 이 데이터를view페이지에서 받을 수 있다.
	public List<SearchType> getSearchType(){
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "팀+선수이름"));
		options.add(new SearchType(2, "팀이름"));
		options.add(new SearchType(3, "선수이름"));
		return options;
	}
	
	@ModelAttribute("queryList")
	public String[] getQueryList() {
		return new String[] {"김혜성","서건창","김하성"};
	}
}
