package Homework;


public class ArrayStudy {

	public static void main(String[] args) {
//		문제 1.
//		int형 1차원 배열을 매개변수로 전달 받아서 배열에 저장된 최대값,
//		그리고 최소값을 구해서 반환하는 메소드를 다음의 형태로 각각 정의.
//		public static int miniValue(int[] arr) { . . . . } // 최소값 반환
//		public static int maxValue(int[] arr) { . . . . } // 최대값 반환
//		위의 두 매소드는 인자로 전달되는 배열의 길이에 상관없이 동작하도록 정의.
//		두 매소드 실행을 확인하기 위한 main 메소드 정의.
//		int형 배열에 채워질 정수는 프로그램 사용자로부터 입력 받고, 배열의 길이는
//		임의로 결정

		ArrayStudy value = new ArrayStudy();
		int[] arr = {10,30,20,1,5};
		System.out.println("minNum : " + value.miniValue(arr));
		System.out.println("maxNum : " + value.maxValue(arr));
		
		int[][] arr1 = new int[][]{
				{2,5,4,1,6},
				{3,1,2,6,5},	
		};
		value.addOneDArr(arr1, 7);
		System.out.println(arr1);

	}
		
	
	
	int min=0;
	int max=0;
	int miniValue(int[] arr) {
		int min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {  
				min=arr[i];   // 참이 될 때 그 값을 대입시켜야 하므로, 부등호가 <가 아니라 >가 되어야함. 
			} 				
		}
		return min;
	}
	
	int maxValue(int[] arr){
		int max=arr[0];
		for(int i=0; i<arr.length; i++) {
	        if(max<arr[i]) {
	        	max=arr[i];
	        }
		}
        return max;
	}
	
	// 문제 2
	void addOneDArr(int[] arr, int add) {
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr[i] + add;
		}
	}
	
	void addOneDArr(int[][] arr1, int add) {
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				arr1[i][j] = arr1[i][j] + add;
			}
		}
		
	}
	
}
