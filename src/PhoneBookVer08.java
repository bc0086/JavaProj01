import java.util.InputMismatchException;
import java.util.Scanner;
import ver08.PhoneSchoolInfo;
import ver08.MenuSelectException;
import ver08.PhoneBookManager;
import ver08.PhoneInfo;
import ver08.MenuItem;
import ver08.PhoneCompanyInfo;

public class PhoneBookVer08 implements MenuItem {

	public static void main(String[] args) {

		PhoneBookManager set = new PhoneBookManager(100);
		int choice = 0;	
		
		while (true) {
			try {
				// 메뉴출력을 위한 메소드호출
				set.printMenu();
				Scanner scan = new Scanner(System.in);

				choice = scan.nextInt();

				switch (choice) {
				case DATA_INPUT: // 데이터입력
					set.dataInput();
					break;

				case DATA_SELECT: // 데이터검색
					set.dataSearch();
					break;

				case DATA_DELETE: // 데이터삭제
					set.dataDelete();
					break;

				case DATA_OUTPUT: // 주소록출력
					set.loadPhoneBookInfo();
					set.dataAllShow();
					break;

				case EXIT: // 프로그램 종료 완
					set.savePhoneBookInfo();
					System.out.println("프로그램을 종료합니다.");
					System.out.println("<<< Process finished." + "(Exit code 0)");
					return;
				}
				
				if (choice > 5 || choice < 0) {
					MenuSelectException mse = new MenuSelectException();
					throw mse;
				}
				
			} // end of try
			
			catch (MenuSelectException e) { //1~5이외의 정수 입력시 기능
				System.out.println(e.getMessage());		
				System.out.println();
			}
			
			catch(InputMismatchException e) { // 정수이외의 문자 입력시 기능
				System.out.println("숫자로만 입력해야 합니다.");
				System.out.println();
			}			

		} // end while

	}

}
