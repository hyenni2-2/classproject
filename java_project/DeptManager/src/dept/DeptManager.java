package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DeptManager {

	// 사용자 입력
	Scanner sc = new Scanner(System.in);

	DeptDao dao = DeptDao.getInstance();

	// 부서입력 메서드 : 사용자에게 입력받은 데이터를 DAO를 이용해서 DB 입력
	void insertDept() {

		// 부서 정보를 받아서 인스턴스를 생성하고 dao.insertDept()처리
		System.out.println("부서 정보를 입력합니다.");
		System.out.println("부서 번호를 입력해 주세요.");
		String deptno = sc.nextLine();
		System.out.println("부서 이름을 입력해 주세요.");
		String dname = sc.nextLine();
		System.out.println("부서 위치를 입력해 주세요.");
		String loc = sc.nextLine();

		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);

		Connection conn = null;


		int resultCnt = 0;

		try {
			conn =ConnectionProvider.getConnection();

			resultCnt = dao.insertDept(dept, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (resultCnt > 0) {
			System.out.println("입력 완료!");
		} else {
			System.out.println("입력 실패!");
		}

	}

	// 부서 정보 수정 메서드 : 사용자에게 입력받고 데이터를 DAO를 이용해서 수정
	void editDept() {
		System.out.println("수정을 원하는 부서 번호를 입력하세요.");
		String deptno = sc.nextLine();
		System.out.println("새로운 부서 이름을 입력해 주세요.");
		String dname = sc.nextLine();
		System.out.println("새로운 지역이름을 입력해 주세요.");
		String loc = sc.nextLine();

		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);

		Connection conn = null;

		int resultCnt = 0;

		try {
			conn =ConnectionProvider.getConnection();
			resultCnt = dao.updateDept(dept, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (resultCnt > 0) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("수정 실패!");
		}

	}

	void delDept() {
		System.out.println("삭제를 원하는 부서번호를 입력하세요.");
		String deptno = sc.nextLine();

		Connection conn = null;

		int resultCnt = 0;

		try {
			conn =ConnectionProvider.getConnection();
			resultCnt = dao.deleteDept(Integer.parseInt(deptno), conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (resultCnt > 0) {
			System.out.println("삭제 완료!");
		} else {
			System.out.println("삭제하려는 정보가 없어요.");
		}

	}

	void listDept() {

		Connection conn = null;

		List<Dept> list = null;

		try {
			conn =ConnectionProvider.getConnection();
			list = dao.listDept(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list.isEmpty()) {
			System.out.println("저장한 정보가 없어요.");
		} else {
			for (Dept d : list) {
				// System.out.println(d); // 참조변수를 받으면 toString 출력됨
				System.out.printf("%5s", d.getDeptno() + "\t");
				System.out.printf("%12s", d.getDname() + "\t");
				System.out.printf("%12s", d.getLoc() + "\n");
			}
		}

	}

	void searchDept() {
		System.out.println("부서를 검색합니다.");
		System.out.println("찾는 부서의 번호를 입력하세요.");
		String deptno = sc.nextLine();

		Connection conn = null;

		Dept dept = null;

		try {
			conn =ConnectionProvider.getConnection();
			dept = dao.searchDept(Integer.parseInt(deptno), conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dept != null) {
			System.out.println(dept);
		} else {
			System.out.println("찾는 정보가 없어요.");
		}

	}

}
