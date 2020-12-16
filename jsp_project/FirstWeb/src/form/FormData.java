package form;

import java.util.Arrays;

// Form에서 전송되는 데이터를 저장하는 BEANS 정의
public class FormData {

// 속성 : 변수는 private 처리
	private String name; // 사용자의 이름
	private String job; // 사용자의 직업 job=null
	private String[] interest; // 관심사

	// beans는 컨테이너가 객체를 생성하기 때문에 기본 생성자는 필수
	public FormData() {
		
	}

	public FormData(String name, String job, String[] interest) {
		this.name = name;
		this.job = job;
		this.interest = interest;
	}

	
	// 각 변수들의 getter/setter 메서드 정의
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String[] getInterest() {
		return interest;
	}

	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "FormData [name=" + name + ", job=" + job + ", interest=" + Arrays.toString(interest) + "]";
	}
	
}
