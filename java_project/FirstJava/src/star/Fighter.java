package star;

public class Fighter extends Unit implements Fightable {

	@Override
	public void move() {   // interface에서 접근제어자가 public이기 때문에 붙여줘야함
		System.out.println("이동합니다.");
	    x+=NUM;
	    y+=NUM;
	}
	
	@Override
	public void attack() {
		System.out.println("공격합니다.");
	    hp-=NUM;
	}
}
