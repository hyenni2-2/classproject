package first;

public class IfLoop {

	public static void main(String[] args) {
		/*
		 * // 1번 int num = 120; if(num>0 && num%2 == 0) {
		 * System.out.println("양수이면서 짝수");
		 */

		/*
		 * // 2번 int num; num = 300; if(num<0) { System.out.println("0 미만"); } else
		 * if(num>=0 && num<100){ System.out.println("0이상 100미만"); } else if(num>=100 &&
		 * num<200) { System.out.println("100이상 200 미만"); } else if(num>=200 && num<300)
		 * { System.out.println("200이상 300 미만"); } else if(num>=300) {
		 * System.out.println("300이상"); }
		 */

		/*
		 * // 문제 3 int num1 = 50, num2 = 100; int big, diff; if(num1>num2) { big = num1;
		 * System.out.println(big); } else if(num2>num1) { big = num2;
		 * System.out.println(big); }
		 * 
		 * if(num1>num2) { diff = num1-num2; System.out.println(diff); } else
		 * if(num2>num1) { diff = num2-num1; System.out.println(diff); }
		 * 
		 * 
		 */

		/*
		 * //문제 4 int n = 3; if(n == 1) { System.out.println("Simple Java"); } else if(n
		 * == 2) { System.out.println("Funny Java"); } else if(n == 3) {
		 * System.out.println("Fantastic Java"); } else {
		 * System.out.println("The best programming language"); }
		 * System.out.println("Do you like coffee?");
		 */

		/*
		 * //문제 5 int num; num = 634; if(num<0) { System.out.println("0 미만"); }
		 * 
		 * switch(num/10) { case 0 : System.out.println("0이상 100 미만"); break; case 1 :
		 * System.out.println("100이상 200 미만"); break; case 2 :
		 * System.out.println("200이상 300 미만"); break; case 3 :
		 * System.out.println("300이상"); break; default: System.out.println("300이상"); }
		 */

		/*
		 * //문제 6 int i = 1; int sum = 0; while(i<=99) { sum = sum + i; i++; }
		 * System.out.println(sum);
		 */

		/*
		 * // 문제 7 int i = 1; while(i<=100) { System.out.println(i); i++; }
		 * 
		 * int k = 100; do { System.out.println(k); k--; }while(k>0);
		 */

		/*
		 * //문제 8 int i = 1; int sum = 0; while(i<=1000) { if(i%14==0) {
		 * System.out.println(i); } i++; sum = sum +i; }
		 * System.out.println("출력된 숫자의 합은 : " + sum );
		 */

		/*
		 * //문제 9 int i; int j; for(i=1; i<11; i++) { for(j=1; j<11; j++) {
		 * System.out.println(i*j); } }
		 */

          /*		
		 //문제 10 
		int i; 
		for(i=1; i<10; i++) {
		 System.out.println("5"+"x"+i); 
		}
		*/

		/*
		// 문제 11
		int num = 0;
		int count = 0;

		/*
		while ((num++) < 100) {
			if (num % 5 != 0 || num % 7 != 0) {
				continue;
			}
			count++;
			System.out.println("num은" + num);
		}
		System.out.println("count:" + count);
        */
		
		/*
		for(num=1; num<100; num++) {
			if(num%5==0 && num%7==0) {
				System.out.println(num);
			    count++;
		        System.out.println(count);
			}
			
		}
		*/
		
		
		//문제 12
		// 자연수 1부터 시작, 모든 홀수 + 3의 배수인 짝수를 더함
		
		int num = 1;
		int sum = 0;
		
		while(true) {
			if(num%2==1 || num%6==0) {
				num++;
			}
			sum += num;
			
			if(sum>=1000) {
				break;
			}
			System.out.println(num);
			System.out.println(sum);
		    
		
		
			
		}
		
		
		
		
		
		
	}

}
