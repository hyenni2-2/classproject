package ver07;

import java.io.Serializable;
// 인터페이스 간의 상속은 implements가 아니라 extends를 사용 
public interface Infor extends Serializable {
	void showInfor();
	void showBasicInfor();
}
