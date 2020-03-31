package ver09;

import java.util.Scanner;
import ver03.PhoneInfo;

public class PhoneBookManager {

// 프로그램의 흐름을 제어하는 목적으로 생성하는 클래스로 해당 프로그램에서 기능을 담당하게 된다.
	private PhoneInfo[] piArr;
	private int numOfPerson;// 친구정보를 추가할때마다 +1 증가

	// 생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다.
	public PhoneBookManager(int num) {
		piArr = new PhoneInfo[num];
		numOfPerson = 0;
	}

	// 데이터입력
	public void dataInput() {

		// 사용자로부터 친구정보를 입력받기위한 준비
		Scanner scan = new Scanner(System.in);
		String name, phoneNumber, birthday;

		// 공통사항 입력받기
		System.out.print("이름:");
		name = scan.nextLine();

		System.out.print("전화번호:");
		phoneNumber = scan.nextLine();

		System.out.print("생년월일:");
		birthday = scan.nextLine();
		
		piArr[numOfPerson++] = new PhoneInfo(name, phoneNumber, birthday);	
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	//데이터 검색
	public void dataSearch() {
	
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		
		String searchName = scan.nextLine();

		for(int i = 0 ; i < numOfPerson ; i++) {			
			System.out.println("검색중인이름:"+ piArr[i].getName());
			
			//검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함
			if(searchName.compareTo(piArr[i].getName())==0) {
				piArr[i].dataAllShow();
				System.out.println("데이터 검색이 완료되었습니다.");
			}
		}
	}////end of dataSearch
	
	//데이터 삭제	
	public void dataDelete() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = scan.nextLine();
		
		/*
		배열의 요소중 삭제된 요소의 인덱스값을 저장할 용도의변수.
		요소를 삭제한후 빈자리를 채울때 사용할 예정임.
		 */
		int deleteIndex = -1;

		for(int i = 0 ; i < numOfPerson ; i++) {
			if(deleteName.compareTo(piArr[i].getName())==0) {
				//요소를 삭제하기 위해 참조값을 null로 변경
				piArr[i] = null;
				//삭제된 요소의 인덱스값 저장
				deleteIndex = i;
				//전체카운트 변수 -1 차감
				numOfPerson--;
			}
		}

		if(deleteIndex==-1) {
			//검색된 데이터가 없는경우...
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		
		else {
			/*
			객체배열에서 검색된 요소를 삭제한후 입력된 위치의 바로뒤 요소를
			앞으로 하나씩 교환한다. 
			 */
			for(int i=deleteIndex ; i<numOfPerson ; i++) {
				piArr[i] = piArr[i+1];
			}
			System.out.println("==데이터("+ deleteIndex
					+"번)가 삭제되었습니다==");
		}
	
	}////end of deleteInfo
	
	//친구정보 전체보기
	public void dataAllShow() {
		for(int i=0 ; i < numOfPerson ; i++) {
			piArr[i].dataAllShow();
		}

		System.out.println("==전체정보가 출력되었습니다==");
	}////end of dataAllShow	
}

	
