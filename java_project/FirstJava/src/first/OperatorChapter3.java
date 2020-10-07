package first;

public class OperatorChapter3 {

	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = (int)(5/9f*(fahrenheit - 32)*100+0.5)/100f;
		// 0.5를 해주면 셋째자리에서 int로 변환했을 때 반올림이 가능하게 됨
		System.out.println(fahrenheit);
		System.out.println(celcius);
		

	}

}
