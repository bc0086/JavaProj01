import java.util.Scanner;

import ex20io.FriendInfoHandler;
import ver02.PhoneInfo;

public class PhoneBookVer03 {

	public static void printMenu() {//
		System.out.println("선택하세요.....");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}

	public static void addPerson() {

		// 사용자로부터 친구정보를 입력받기 위한 준비
		Scanner scan = new Scanner(System.in);
		String name, phoneNumber, birthday;

		// 공통사항 입력받기
		System.out.print("이름:");
		name = scan.nextLine();

		System.out.print("전화번호:");
		phoneNumber = scan.nextLine();

		System.out.print("생년월일:");
		birthday = scan.nextLine();

		PhoneInfo phoneinfo = new PhoneInfo(name, phoneNumber, birthday);
		
		phoneinfo.showPhoneInfo();

	}

	public static void main(String[] args) {

		PhoneBookManager handler = new PhoneBookManager(100);
		
		while (true) {
			// 메뉴출력을 위한 메소드호출
			printMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch (choice) {
			case 1: //데이터입력 완
				dataInput();
				break;
				
			case 2: //데이터검색
				dataSearch();
				break;
				
			case 3: //데이터삭제
				dataDelete();
				break;
				
			case 4: //주소록출력
				dataAllShow();
				break;


			case 5: //프로그램 종료 완
				System.out.println("프로그램을 종료합니다.");
				return;// main함수의 종료는 프로그램 종료로 이어진다.
			}

		} // end of while

	}

}
