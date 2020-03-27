import java.util.Scanner;
import ver04.PhoneBookManager;
import ver04.PhoneInfo;
import ver05.MenuItem;
import ver04.PhoneCompanyInfo;

public class PhoneBookVer05 implements MenuItem {

	public static void printMenu()  {
		
		System.out.println("03Lecture\\03.JAVA\\Java소스"
				+ "\\Ver1.0\\LevelProject" 
				+ "java PhoneBookVer04\n" 
				+ "Process started >>>");
		System.out.println();
		System.out.println("선택하세요.....");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 주소록 출력");
		System.out.println("5. 프로그램 종료");
	}

	public static void main(String[] args)  {

		PhoneBookManager piArr = new PhoneBookManager(100);
		
		while (true) {
			// 메뉴출력을 위한 메소드호출
			printMenu();
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();

			switch (choice) {
			case DATA_INPUT: //데이터입력 완
				piArr.dataInput();
				break;
				
			case DATA_SELECT: //데이터검색 완
				piArr.dataSearch();
				break;
				
			case DATA_DELETE: //데이터삭제 완
				piArr.dataDelete();
				break;
				
			case DATA_OUTPUT: //주소록출력 완
				piArr.dataAllShow();
				break;


			case EXIT : //프로그램 종료 완
				System.out.println("프로그램을 종료합니다.");
				System.out.println("<<< Process finished." 
						+ "(Exit code 0)");
				return;
			}

		} 

	}

}
