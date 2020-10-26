package io;

import java.io.Serializable;

public class Circle2 implements Serializable {

	// implements Serializable : 직렬화의 대상이다, 인스턴스 저장이 가능.
	// 직렬화를 하기 위해서는 반드시 implements Serializable를 구현해줘야한다.

	// transient : 직렬화 대상에서 제외
	// transient Point p;   // 직렬화가 안되므로 null값이 됨 but 인스턴스는 만들어짐
	Point p;
	double rad;
	
	public Circle2(int xPos, int yPos, double rad) {
		p = new Point(xPos, yPos);
		this.rad=rad;
	}
	
	public void showCircleInfo() {
		System.out.printf("[%d,%d] \n",p.x,p.y);
		System.out.println("rad : " +rad);
	}
	
	
}
