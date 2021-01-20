package com.aia.firstspring.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class GuestMessageList2 {
	
	@XmlElement(name = "message")
	private List<GuestMessage2> message;  // message를 xml로 바꾼다는 어노테이션(xmlaccessorType)
	
	public GuestMessageList2() {
		
	}
	
	public GuestMessageList2(List<GuestMessage2> message) {
		this.message = message;
	}

	public List<GuestMessage2> getMessage() {
		return message;
	}

	public void setMessage(List<GuestMessage2> message) {
		this.message = message;
	}
	
	

}
