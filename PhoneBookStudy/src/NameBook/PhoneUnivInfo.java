package NameBook;

public class PhoneUnivInfo extends NameBookInfo {

	private String major;
	private String year;

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public PhoneUnivInfo(String name, String phoneNumber, String address, String email, String major, String year) {
		super(name, phoneNumber, address, email);
		this.major = major;
		this.year = year;
	}

	@Override
	public void showAll() {
		super.showAll();
		System.out.println("전공 : " + major);
		System.out.println("학년 + " + year);
	}

}
