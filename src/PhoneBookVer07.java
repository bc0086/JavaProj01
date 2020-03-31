import java.util.InputMismatchException;
import java.util.Scanner;
import ver07.PhoneSchoolInfo;
import ver07.MenuSelectException;
import ver07.PhoneBookManager;
import ver07.PhoneInfo;
import ver07.MenuItem;
import ver07.PhoneCompanyInfo;

public class PhoneBookVer07 implements MenuItem {

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
<<<<<<< HEAD
				case DATA_INPUT: // 데이터입력
					set.dataInput();
=======
				case DATA_INPUT: 
					piArr.dataInput();
>>>>>>> refs/remotes/origin/master
					break;

<<<<<<< HEAD
				case DATA_SELECT: // 데이터검색
					set.dataSearch();
=======
				case DATA_SELECT:
					piArr.dataSearch();
>>>>>>> refs/remotes/origin/master
					break;

<<<<<<< HEAD
				case DATA_DELETE: // 데이터삭제
					set.dataDelete();
=======
				case DATA_DELETE: 
					piArr.dataDelete();
>>>>>>> refs/remotes/origin/master
					break;

<<<<<<< HEAD
				case DATA_OUTPUT: // 주소록출력
					set.dataAllShow();
=======
				case DATA_OUTPUT: 
					piArr.dataAllShow();
>>>>>>> refs/remotes/origin/master
					break;

				case EXIT: 
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
