package NameBook;

public class BloodTypeInfo extends NameBookInfo {

private char bloodType;



	public char getBloodType() {
	return bloodType;
}



public void setBloodType(char bloodType) {
	this.bloodType = bloodType;
}

	public BloodTypeInfo(String name, String phoneNumber, String email, char bloodType) {
		super(name, phoneNumber, email);
		this.bloodType=bloodType;		
	}



	@Override
	void showPart() {
			super.showPart();
			System.out.println("혈액형 : " + getBloodType());
	}
	
	

	
	
	
}
