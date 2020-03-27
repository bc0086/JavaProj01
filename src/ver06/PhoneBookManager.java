package ver06;

import java.util.Scanner;
import ver05.SubMenuItem;
import ver05.PhoneCompanyInfo;
import ver05.PhoneSchoolInfo;
import ver05.PhoneInfo;

public class PhoneBookManager implements SubMenuItem {

	private PhoneInfo[] piArr;
	private int numOfPerson;

	// 생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다.
	public PhoneBookManager(int num) {
		piArr = new PhoneInfo[num];
		numOfPerson = 0;
	}
	
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
			piArr[numOfPerson++] = new PhoneInfo(name, phoneNumber);
			break;

		case DATA_SCHOOL: // 동창
			System.out.print("전공:");
			major = scan.next();

			System.out.print("학년:");
			grade = scan.nextInt();

			piArr[numOfPerson++] = new PhoneSchoolInfo(name, phoneNumber, major, grade);
			break;

		case DATA_COMPANY: // 회사
			System.out.print("회사명:");
			emp = scan.next();

			piArr[numOfPerson++] = new PhoneCompanyInfo(name, phoneNumber, emp);
			break;

		}

		System.out.println("데이터 입력이 완료되었습니다.");
		System.out.println();
	}

	// 데이터 검색
	public void dataSearch() {

		Scanner scan = new Scanner(System.in);

		System.out.print("검색할 이름을 입력하세요:");

		String searchName = scan.nextLine();

		for (int i = 0; i < numOfPerson; i++) {
			System.out.println("검색중인이름:" + piArr[i].name);

			// 검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함
			if (searchName.compareTo(piArr[i].name) == 0) {
				piArr[i].dataAllShow();
				System.out.println("데이터 검색이 완료되었습니다.");
				System.out.println();
			}
		}
	}//// end of dataSearch

	// 데이터 삭제
	public void dataDelete() {

		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();

		/*
		 * 배열의 요소중 삭제된 요소의 인덱스값을 저장할 용도의변수. 요소를 삭제한후 빈자리를 채울때 사용할 예정임.
		 */
		int deleteIndex = -1;

		for (int i = 0; i < numOfPerson; i++) {
			if (deleteName.compareTo(piArr[i].name) == 0) {
				// 요소를 삭제하기 위해 참조값을 null로 변경
				piArr[i] = null;
				// 삭제된 요소의 인덱스값 저장
				deleteIndex = i;
				// 전체카운트 변수 -1 차감
				numOfPerson--;
			}
		}

		if (deleteIndex == -1) {
			// 검색된 데이터가 없는경우...
			System.out.println("==삭제된 데이터가 없습니다==");
		}

		else {
			/*
			 * 객체배열에서 검색된 요소를 삭제한후 입력된 위치의 바로뒤 요소를 앞으로 하나씩 교환한다.
			 */
			for (int i = deleteIndex; i < numOfPerson; i++) {
				piArr[i] = piArr[i + 1];
			}
			System.out.println("==데이터(" + deleteIndex + "번)가 삭제되었습니다==");
		}

	}//// end of deleteInfo

	// 친구정보 전체보기
	public void dataAllShow() {
		for (int i = 0; i < numOfPerson; i++) {
			piArr[i].dataAllShow();
		}

		System.out.println("==전체정보가 출력되었습니다==");
		System.out.println();
	}//// end of dataAllShow
}
