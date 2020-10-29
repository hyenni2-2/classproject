package pbPjtVer07;

public class MenuException extends Exception {

	private int put;
	
	public MenuException(int put) {
		super("입력 에러입니다.");
		this.put=put;
	}
	
}
