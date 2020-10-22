package generic;

public class FruixBoxMain2 {

	public static void main(String[] args) {

        FruitBox box1 = new FruitBox(new Apple(100));
        //box1.store(new Apple(100));
        Apple apple = (Apple)box1.pullOut();
        apple.showWeight();
        
        FruitBox box2 = new FruitBox(new Apple(10));
        //box2.store("Apple");  // Apple 타입만 들어가야 한다
        Apple apple2 = (Apple)box2.pullOut();
        apple2.showWeight();
	}

}
