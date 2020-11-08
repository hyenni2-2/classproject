package NameBook;

public class BloodTypeInfo extends NameBookInfo {

	private String bloodType;

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public BloodTypeInfo(String name, String phoneNumber, String email, String bloodType) {
		super(name, phoneNumber, email);
		this.bloodType = bloodType;
	}

	@Override
	void showAll() {
		super.showAll();
		System.out.println("혈액형 : " + bloodType);
	}

}
