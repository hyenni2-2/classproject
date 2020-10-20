package Homework;

public class PersonalInfo {  // 조상 클래스
	String name;
	String number;
	
	PersonalInfo(String name, String number){
		this.name=name;
		this.number=number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	

}
