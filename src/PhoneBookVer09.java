import java.util.Scanner;
import ver09.PhoneBookManager;

public class PhoneBookVer09 {

	public static void printMenu() {
		
		System.out.println();
		System.out.println("선택하세요.....");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}

	public static void main(String[] args) {

		PhoneBookManager piArr = new PhoneBookManager();
		
		while (true) {
			// 메뉴출력을 위한 메소드호출
			printMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch (choice) {
			case 1: //데이터입력
				piArr.dataInput();
				break;
				
			case 2: //데이터검색
				piArr.dataSearch();
				break;
				
			case 3: //데이터삭제
				piArr.dataDelete();
				break;
				
			case 4: //주소록출력
				piArr.dataAllShow();
				break;

			case 5: //프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;// main함수의 종료는 프로그램 종료로 이어진다.
			}

		} // end of while

	}

}
