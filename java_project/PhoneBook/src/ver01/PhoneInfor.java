package ver01;

public class PhoneInfor {
	
       String name;
       String phoneNumber;
       String birthday;
       
       //생성자 받기
       PhoneInfor(String name, String phoneNumber, String birthday){
    	   this.name=name;
    	   this.phoneNumber=phoneNumber;
    	   this.birthday=birthday;
       }
       
       // 오버로딩 생성자
       PhoneInfor(String name, String phoneNumber){
 //   	   this.name=name;
 //   	   this.phoneNumber=phoneNumber;
    	   //this(name, phoneNumber, "생일정보 없음");
    	   this(name, phoneNumber, null);
       }
       
       void showInfor() {
    	   System.out.println("이름 : " + name);
    	   System.out.println("전화번호 : " + phoneNumber);    	   
    	  
    	   if(birthday == null) {
    		   System.out.println("생일 : 입력 데이터 없음");
    	   } else {
        	   System.out.println("생일 : " + birthday); 
    	   }
       }
       
       
	
	

}
