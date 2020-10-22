package generic;

public class FruixBoxMain {

	public static void main(String[] args) {

		AppleBox applebox = new AppleBox();
		applebox.store(new Apple(10));    
		Apple apple = applebox.pullOut();
		apple.showWeight();
		
		OrangeBox orangebox = new OrangeBox();
		//orangebox.stone(new string("오렌지"));
		orangebox.store(new Orange(100));
		Orange orange = orangebox.pullOut();
		orange.showSugarContent();

	}

}
