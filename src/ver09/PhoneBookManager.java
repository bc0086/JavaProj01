package ver09;
import java.lang.Exception;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import ver09.SubMenuItem;
import ver09.PhoneCompanyInfo;
import ver09.PhoneSchoolInfo;
import ver09.PhoneInfo;
import java.io.Serializable;

public class PhoneBookManager implements SubMenuItem  {

	// 생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다.
	public PhoneBookManager(int i) {}
	
	//set컬렉션 생성
	HashSet<PhoneInfo> set = new HashSet<PhoneInfo>();

	public void printMenu() {

		System.out.println("03Lecture\\03.JAVA\\Java소스" + "\\Ver1.0\\LevelProject" + "java PhoneBookVer04\n"
				+ "Process started >>>");
		System.out.println();
		System.out.println("선택하세요.....");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}

	// 데이터입력
	public void dataInput() {

		Scanner scan = new Scanner(System.in);
		String name, phoneNumber, major, emp;
		int grade;

		System.out.println("데이터 입력을 시작합니다..");
		System.out.print("1.일반, 2.동창, 3.회사");

		int choice = scan.nextInt();

		// 공통사항 입력받기
		System.out.println("이름:");
		name = scan.next();

		System.out.println("전화번호:");
		phoneNumber = scan.next();

		switch (choice) {
		case DATA_BASIC: // 일반
			
			//HashSet컬렉션으로 객체생성1
			if(set.add(new PhoneInfo(name, phoneNumber))==false) {
				
				int select;
				
				System.out.println("이름이 중복됩니다.");
				System.out.println("1번. 새로 변경,	2번. 기존 정보 유지");
				select = scan.nextInt();

				switch (select) {
				case 1: 
					set.remove(new PhoneInfo(name, phoneNumber));
					set.add(new PhoneInfo(name, phoneNumber));	
					System.out.println("새로운 정보 변경 완료");
					break;

				case 2: // 데이터검색
					System.out.println("기존 정보 유지 완료");
					break;				
				}				
			}
			break;
			
			
			/*
			PhoneInfo pi1 = new PhoneInfo(name, phoneNumber);
			PhoneInfo pi2 = new PhoneInfo(name, phoneNumber);
			set.add(pi1);
			set.add(pi2);
			
			이렇게 표현해야 할 것을 다음과 같이 표현가능하게 됨.
			
			set.add(new PhoneInfo(name, phoneNumber);
			break;
			*/

		case DATA_SCHOOL: // 동창
			System.out.print("전공:");
			major = scan.next();

			System.out.print("학년:");
			grade = scan.nextInt();

			//HashSet컬렉션으로 객체생성2			
			if(set.add(new PhoneSchoolInfo(name, phoneNumber, major, grade))==false) {
				
				int select;
				
				System.out.println("이름이 중복됩니다.");
				System.out.println("1번. 새로 변경,	2번. 기존 정보 유지");
				select = scan.nextInt();

				switch (select) {
				case 1: 
					set.remove(new PhoneSchoolInfo(name, phoneNumber, major, grade));
					set.add(new PhoneSchoolInfo(name, phoneNumber, major, grade));	
					System.out.println("새로운 정보 변경 완료");
					
					break;

				case 2: // 데이터검색
					System.out.println("기존 정보 유지 완료");
					break;				
				}				
			}
			break;			

		case DATA_COMPANY: // 회사
			System.out.print("회사명:");
			emp = scan.next();

			//HashSet컬렉션으로 객체생성3			
			if(set.add(new PhoneCompanyInfo(name, phoneNumber, emp))==false) {
				
				int select;
				
				System.out.println("이름이 중복됩니다.");
				System.out.println("1번. 새로 변경,	2번. 기존 정보 유지");
				select = scan.nextInt();

				switch (select) {
				case 1: 
					set.remove(new PhoneCompanyInfo(name, phoneNumber, emp));
					set.add(new PhoneCompanyInfo(name, phoneNumber, emp));	
					System.out.println("새로운 정보 변경 완료");
					break;

				case 2: // 데이터검색
					System.out.println("기존 정보 유지 완료");
					break;
				}
			}
			break;
			
		} // end of case
		
		//객체저장 확인		
		System.out.println("데이터 입력이 완료되었습니다.");
		//저장된 객체수 얻기
		System.out.println("[중복저장전 객체수]:"+ set.size());
		System.out.println();
		
	} // end of dataInput()

	// 데이터 검색
	public void dataSearch() {

		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();		
		
		boolean searchFlag = false;//검색결과 유무 확인
		
		Iterator<PhoneInfo> itr = set.iterator(); //반복자를 통한 순차접근
		
		while(itr.hasNext()) {			
			PhoneInfo phoneinfo = itr.next();
			if(searchName.equals(phoneinfo.name)) {
				//검색결과가 있다면 플레그를 변경
				searchFlag = true;
				//toString()메소드를 오버라이딩 했으므로 객체를 즉시 출력가능.
				System.out.println(phoneinfo);
			}
		}
		
		if(searchFlag == true) {
			System.out.println("요청한 정보를 찾았습니다.");
		}
		
		else {
			System.out.println("요청한 정보는 없습니다.");
		}
		
	}//// end of dataSearch

	// 데이터 삭제
	public void dataDelete() {

		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();

		boolean deleteFlag = false;//검색결과 유무 확인
		
		Iterator<PhoneInfo> itr = set.iterator(); //반복자를 통한 순차접근
		
		while(itr.hasNext()) {			
			PhoneInfo phoneinfo = itr.next();
			if(deleteName.equals(phoneinfo.name)) {
				//검색결과가 있다면 플레그를 변경
				deleteFlag = true;
				//toString()메소드를 오버라이딩 했으므로 객체를 즉시 출력가능.
				System.out.println(phoneinfo);
			}
		}
		
		if(deleteFlag == true) {
			set.remove(deleteName);					
			System.out.println("요청한 " +deleteName+"의 정보를 삭제했습니다.");
			System.out.println("[삭제 후 객체수]"+ set.size());
			System.out.println();
		}
		
		else {
			System.out.println("삭제된 데이터가 없습니다..");
			System.out.println();
		}

	}//// end of deleteInfo

	 //친구정보 전체보기
	public void dataAllShow() {			
		Iterator<PhoneInfo> itr = set.iterator();
		
		while(itr.hasNext()) {			
			System.out.println(itr.next());
		}
		
		System.out.println("==전체정보가 출력되었습니다==");
		System.out.println();
	}//// end of dataAllShow
	
	//정보를 파일형태로 저장하기
	public void savePhoneBookInfo() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/ver08/PhoneBook.obj"));
						
			System.out.println(set);
			out.writeObject(set);
			
			out.close();
			
		}
		
		catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}		
	}
	
	public void loadPhoneBookInfo() {
		
		try {
			//역직렬화(복원)을 위한 스트림 생성
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream("src/ver08/PhoneBook.obj"));
			
			//저장된 파일에서 정보 1개 읽어오기
			HashSet<PhoneInfo> loadset = (HashSet<PhoneInfo>) in.readObject();
			
			Iterator<PhoneInfo> itr = loadset.iterator();
			
			while(itr.hasNext()) {			
				itr.next().dataAllShow();
			}	
					
		}
		
		catch(Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
		
	} //end of loadPhoneBookInfo
			
}


	
