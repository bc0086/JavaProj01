import java.util.Scanner;
import ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void menuShow() {
		System.out.println("***메뉴를 선택하시요***");
		System.out.println("1. 입력");
		System.out.println("2. 종료");
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

		while (true) {
			// 메뉴출력을 위한 메소드호출
			menuShow();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				addPerson();
				break;

			case 2:
				System.out.println("프로그램을 종료합니다.");
				return;// main함수의 종료는 프로그램 종료로 이어진다.
			}

		} // end of while

	}

}
