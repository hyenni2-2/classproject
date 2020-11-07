package NameBook;

public class PhoneCompanyInfo extends NameBookInfo {

	private String company;	

	
public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


public PhoneCompanyInfo(String name, String phoneNumber, String email, String company) {
		super(name, phoneNumber,email);
		this.company=company;
		
	}


@Override
void showPart() {
	super.showPart();
	System.out.println("회사 : " + getCompany());
}




	
	

}
