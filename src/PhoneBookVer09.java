import java.util.Scanner;
import ver03.PhoneBookManager;
import ver03.PhoneInfo;

public class PhoneBookVer09 {

	public static void printMenu() {
		
		System.out.println();//
		System.out.println("선택하세요.....");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}

//	public static void dataInput() {
//
//		// 사용자로부터 친구정보를 입력받기 위한 준비
//		Scanner scan = new Scanner(System.in);
//		String name, phoneNumber, birthday;
//
//		// 공통사항 입력받기
//		System.out.print("이름:");
//		name = scan.nextLine();
//
//		System.out.print("전화번호:");
//		phoneNumber = scan.nextLine();
//
//		System.out.print("생년월일:");
//		birthday = scan.nextLine();
//
//		PhoneInfo phoneinfo = new PhoneInfo(name, phoneNumber, birthday);//		
//		phoneinfo.dataAllShow();
//
//	}

	public static void main(String[] args) {

		PhoneBookManager piArr = new PhoneBookManager(100);
		
		while (true) {
			// 메뉴출력을 위한 메소드호출
			printMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch (choice) {
			case 1: //데이터입력 완
				piArr.dataInput();
				break;
				
			case 2: //데이터검색 완
				piArr.dataSearch();
				break;
				
			case 3: //데이터삭제
				piArr.dataDelete();
				break;
				
			case 4: //주소록출력
				piArr.dataAllShow();
				break;


			case 5: //프로그램 종료 완
				System.out.println("프로그램을 종료합니다.");
				return;// main함수의 종료는 프로그램 종료로 이어진다.
			}

		} // end of while

	}

}
