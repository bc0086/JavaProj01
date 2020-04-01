package ver09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PhoneBookManager {
	
	//멤버변수
	Connection con; // DB연결을 위한 객체
	Statement stmt; // 쿼리전송 및 실행을 위한 객체
	PreparedStatement psmt; // 쿼리전송 및 실행을 위한 객체
	ResultSet rs; // execteQuery의 명령에 대한 반환값
	
	//DB연결
	public PhoneBookManager() { 
		
		try {
			//1.오라클 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//2.커넥션 객체를 통해 DB연결
			con = DriverManager.getConnection(
					"jdbc:oracle:thin://@localhost:1521:orcl",
					"kosmo",
					"1234");
			
			System.out.println("오라클 DB 연결성공");
		 }
		
		 catch (ClassNotFoundException e) {
			 //ojdbc6.jar파일이 없거나 연동되지 않았을때 예외발생
			 System.out.println("오라클 드라이버 로딩 실패");
			 e.printStackTrace();
		 }
		
		 catch (SQLException e) {
			 //커넥션URL이나 계정명이 잘못되었을때 발생되는 예외
			 System.out.println("DB 연결 실패");
			 e.printStackTrace();
		 }
		
		 catch (Exception e) {
			 System.out.println("알수 없는 예외발생");
		 }
		
	} // end of 연결
	
	
	
	// 데이터입력	
	public void dataInput() {
		
		try {
			//1.쿼리문준비 : 값의 세팅이 필요한 부분을 ?로 대체한다. 
			String query = "INSERT INTO phonebook_tb VALUES (?, ?, ?)";
			
			//2.prepared객체 생성 : 생성시 준비한 쿼리문을 인자로 전달한다. 
			psmt = con.prepareStatement(query);
			
			// 공통사항 입력받기
			Scanner scan = new Scanner(System.in);
			
			System.out.print("이름:");
			String name = scan.nextLine();
			
			System.out.print("전화번호:");
			String phone = scan.nextLine();
			
			System.out.print("생일:");
			String birthday = scan.nextLine();
			
			//4.인파라미터 설정하기 : ?의 순서대로 설정하고 DB이므로 인덱스는 1부터 시작.
			psmt.setString(1, name);
			psmt.setString(2, phone);
			psmt.setString(3, birthday);
			
			//5.쿼리실행을 위해 prepared객체를 실행한다. 
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었습니다.");			
		}
		
		catch(Exception e) {
			System.out.println("이미 저장된 이름입니다. 다른이름을 입력하세요.");
		}
		
		finally {
			close();
		}
		
	} // end of input
	
	
	
	// 데이터 검색
	public void dataSearch() {
		
		try {   			
			Scanner scan = new Scanner(System.in);
			System.out.print("검색할 이름을 입력하세요:");		
			String searchName = scan.nextLine();
			
			// 1. Statement객체 생성을 위한 메소드 호출
			stmt = con.createStatement();
			
			// 2. SQL(쿼리문)문 작성
			String query = "SELECT name, phone, birthday "
					+ "FROM phonebook_tb "
					+ "WHERE name like '" + searchName +"'";
			
			/* 쿼리 실행 및 결과값 반환			
			 executeUpdate() : 쿼리문이 insert/update/delete와 같이
			 	기존레코드에 영향을 미치는 쿼리를 실행할때 사용한다. 
			 	실행후 영향을 받은 행의 갯수(int)가 반환된다. 
			 
			 executeQuery() : 쿼리문이 select일때 호출하는 메소드로
				레코드에 영향을 미치지 않는 쿼리를 실행한다. 즉, 
				조회만 진행하고, 반환타입은 ResultSet이다.
			*/
			
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String birthday = rs.getString("birthday");
				System.out.printf("이름. %-5s 전화번호. %-5s 생일. %-5s\n", name, phone, birthday);
			}
						
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();		
		}
		
		finally {
			close(); //DB자원반납
		}
		
	} // end of search
	
	
	
	//데이터 삭제	
	public void dataDelete() {
			
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		try {			
			//1.쿼리문준비 : 값의 세팅이 필요한 부분을 ?로 대체한다. 
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			
			//2.prepared객체 생성 : 생성시 준비한 쿼리문을 인자로 전달한다. 
			psmt = con.prepareStatement(query);			
			
			//4.인파라미터 값 설정
			psmt.setString(1, scanValue("삭제할 이름"));
			
			//5.쿼리실행후 결과값 반환
			System.out.println(psmt.executeUpdate() 
					+"행이 삭제되었습니다");
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			close();
		}
		
	} // end of delete
	
	
	
	public String scanValue(String title) {		
		Scanner scan = new Scanner(System.in);
		System.out.print(title +"을(를) 재입력시 삭제됩니다.(exit->종료):");
		String inputStr = scan.nextLine();
		/*
		equalsIgnoreCase()
		 	: equals()메소드와 동일하게 문자열이 같은지 비교하는 메소드로
		 	다른점은 대소문자를 구분하지 않는다. 
		 */
		if("EXIT".equalsIgnoreCase(inputStr)) {   
			System.out.println("프로그램을 종료합니다.");
			close();
			//프로그램 자체가 즉시 종료된다. 
			System.exit(0);
		}
		
		return inputStr;
		
	}
	
	
	
	// 데이터 전체 정보 출력
	public void dataAllShow() {
		
		try {			
			// 1. Statement객체 생성을 위한 메소드 호출
			stmt = con.createStatement();
			
			// 2. SQL(쿼리문)문 작성
			String query = "SELECT * FROM phonebook_tb ";
			
			// 3. executeQuery()문 작성
			/*
			executeQuery() : 쿼리문이 select일때 호출하는 메소드로
			레코드에 영향을 미치지 않는 쿼리를 실행한다. 즉, 
			조회만 진행하고, 반환타입은 ResultSet이다.
			*/ 
			rs = stmt.executeQuery(query);
			
			System.out.println("전체 정보(이름, 전화번호, 생일)를 출력합니다.");
			
			while(rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String birthday = rs.getString("birthday");
				System.out.printf("%-10s %-10s %-10s\n", name, phone, birthday);
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	// 자원반납 (공통)
	public void close() {
		
		try {
			//if(con!=null) con.close();
			if(psmt!=null) psmt.close();	
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
			System.out.println("자원 반납 완료");
		}
		
		catch(Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
		
	}
		
}