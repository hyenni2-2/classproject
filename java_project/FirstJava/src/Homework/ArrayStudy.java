package Homework;

import java.util.Scanner;

public class ArrayStudy {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		int[] arr; // 배열 선언
	    int length; // 배열의 길이 선언 
		System.out.println("배열의 길이는? ");   // 길이를 먼저 알아야 배열이 몇 개 들어가는지 알 수 있다.
		length = sc.nextInt();
		arr = new int[length];  // 길이를 넣어서 길이 = 배열 요소 개수니까. 
	    for(int i=0; i<arr.length; i++) {
	    	System.out.println((i+1) +"회차 요소는 : ");
	    	arr[i] = sc.nextInt(); // 배열 안의 arr[i]값을 참조하고 싶은거니까, arr[i]로 넣어야함. arr로 넣으면 주소값나옴;;
	    }
		ArrayStudy value = new ArrayStudy(); // 호출 메서드 선언
		System.out.println("minNum : " + value.miniValue(arr));
		System.out.println("maxNum : " + value.maxValue(arr));
		
        System.out.println("=========================");

		int[][] arr1 = {
				{10,30,20,1,5},
				{1,3,5}
		};
        value.addOneDArr(arr1, 4);

        System.out.println("=========================");
        
        int[][] arr2 = {
        		{1,2,3},
        		{4,5,6},
        		{7,8,9}
        };
        value.shiftArr(arr2);
        
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
//	이 메서드를 기반으로(이 메서들르 호출하는 형태로)
// int형 2차원 배열에 저장된 값 전부를 증가시키는 메서드를 다음의 형태로 정의하자.
//	public static void addOneDArr(int[][] arr, int add) { . . . . . }
//	단 위 메서드는 2차원 배열의 가로, 세로 길이에 상관없이 동작해야 하며, 
// 위의 메서드가 제대로 동작하는지 확인하기 위한 main 메서드도 함께 정의해야 한다.
	
//	void addOneDArr(int[] arr, int add) {  // 주어진 메서드
//		for(int i=0; i<arr.length; i++) {  // 이 메서드를 호출해서 2차원으로.
//			arr[i] = arr[i]+add;
//		}
//	}
	
	
	
	
	void addOneDArr(int[][] arr1, int add) {    //2차원 배열 메서드
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				arr1[i][j] = arr1[i][j] + add;
				System.out.print(arr1[i][j]+" "); // 배열 정리하기 위해 print와 " " 공백 포함
			}
			System.out.println(); // 개행
		}
	}
		
		
//		문제 3.
//		다음의 형태로 표현된 2차원 배열이 존재한다고 가정해 보자.
//		1 2 3
//		4 5 6
//		7 8 9
//		이러한 형태를 갖는 int형 2차원 배열이 인자로 전달되면, 
//		다음의 형태로 배열의 구조를 변경시키는 메서드를 정의해 보자.
//		7 8 9
//		1 2 3
//		4 5 6
//      즉 총 N행으로 이뤄진 2차원 배열이 존재한다면, 
//      메서드 호출 시, 1행은 2행으로 이동이 이뤄져야한다. 
        void shiftArr(int[][] arr2) {
           int[][] temp = new int[arr2.length][arr2[0].length]; // 열은 바뀌지 않음.
           for(int i=0; i<arr2.length-1; i++) { //번지로 계산하는거니까 길이에서 -1을 해야함
        	   temp[i] = arr2[i];
        	   arr2[i] = arr2[i+2];
        	   arr2[i+2] = arr2[i+1];
        	   arr2[i+1] = temp[i];
        	   if(i==0) {
        		   for(i=0; i<arr2.length; i++) {
                	   for(int j=0; j<arr2[i].length; j++) {
                		   System.out.print(arr2[i][j]+" "); 
                	   }
                	   System.out.println();
                   }
        	   }
           }
           
           
        }
		
		
        	

		
		
		
		
		
}
