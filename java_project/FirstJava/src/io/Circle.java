package io;

import java.io.Serializable;

public class Circle implements Serializable {

	// implements Serializable : 직렬화의 대상이다, 인스턴스 저장이 가능.
	// 직렬화를 하기 위해서는 반드시 implements Serializable를 구현해줘야한다.

	int xPos;
	int yPos;
	double rad;
	
	public Circle(int xPos, int yPos, double rad) {
		this.xPos=xPos;
		this.yPos=yPos;
		this.rad=rad;
	}
	
	public void showCircleInfo() {
		System.out.printf("[%d,%d] \n",xPos,yPos);
		System.out.println("rad : " +rad);
	}
	
	
}
