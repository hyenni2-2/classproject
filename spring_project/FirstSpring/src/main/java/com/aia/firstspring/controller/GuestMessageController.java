package com.aia.firstspring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aia.firstspring.domain.GuestMessage;
import com.aia.firstspring.domain.GuestMessage2;
import com.aia.firstspring.domain.GuestMessageList;
import com.aia.firstspring.domain.GuestMessageList2;

@Controller
public class GuestMessageController {
	
	@RequestMapping("/message/listXml") 
	@ResponseBody
	public GuestMessageList listXml() {
		return getMessageList();
	}
	
	@RequestMapping("/message/listJson") 
	@ResponseBody
	public GuestMessageList2 listXml2() {
		return getMessageList2();
	}

	private GuestMessageList getMessageList() {

		List<GuestMessage> list = new ArrayList<GuestMessage>();
		list.add(new GuestMessage(1, "안녕", new Date()));
		list.add(new GuestMessage(2, "HELLO", new Date()));
		list.add(new GuestMessage(3, "빠이", new Date()));
		return new GuestMessageList(list);
	}	
	
	private GuestMessageList2  getMessageList2() {

		List<GuestMessage2> list = new ArrayList<GuestMessage2>();
		list.add(new GuestMessage2(1, "안녕", new Date()));
		list.add(new GuestMessage2(2, "HELLO", new Date()));
		list.add(new GuestMessage2(3, "빠이", new Date()));
		return new GuestMessageList2(list);
	}	

}
