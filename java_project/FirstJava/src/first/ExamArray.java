package first;

public class ExamArray {

	public static void main(String[] args) {
	    

	}

	
	

//	문제 3.
//	다음의 형태로 표현된 2차원 배열이 존재한다고 가정해 보자.
//	1 2 3
//	4 5 6
//	7 8 9
//	이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 
//	다음의 형태로 배열의 구조를 변경시키는 메서드를 정의해 보자.
//	7 8 9
//	1 2 3
//	4 5 6
//  즉 총 N행으로 이뤄진 2차원 배열이 존재한다면, 
//  메서드 호출 시, 1행은 2행으로 이동이 이뤄져야한다. 
// [0] = [2]
// [1] = [0]
// [2] = [1]
// 주소값 변경을 위한 임시 배열 만들기
	public static void changeArr(int[][] arr) {
	int[] temp = new int[arr[0].length];
	temp = arr[arr.length-1];      // 2차원 배열의 마지막 요소인 1차원 배열 temp에 저장
	                               // 마지막 번지값을 알고 싶기 때문에 길이(개수)-1로 함
	for(int i=arr.length-1; i>0; i--) {
		arr[i]=arr[i-1];
	}
	    arr[0]=temp;
	
	
	}
	
	
}
