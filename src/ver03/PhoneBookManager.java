package ver03;

public class PhoneBookManager {

// 프로그램의 흐름을 제어하는 목적으로 생성하는 클래스로 해당 프로그램에서 기능을 담당하게 된다.
	class FriendInfoHandler {
		//멤버변수
		/*
		Friend타입의 객체배열은 하위클래스인 High, Univ객체를 
		모두 저장할수 있으므로, 하나의 배열내에 2개의 객체를 
		동시에 저장하여 관리할 수 있다.   
		 */
		private Friend[] myFriends;
		private int numOfFriends;//친구정보를 추가할때마다 +1 증가
	 
		//생성자 : 인자로 전달되는 num크기로 객체배열을 생성한다. 
		public FriendInfoHandler(int num) {
	 		myFriends = new Friend[num];
			numOfFriends = 0;
		}
		
		
		//친구정보 전체보기
		public void showAllData() {
			for(int i=0 ; i<numOfFriends ; i++) {
				myFriends[i].showAllData();
			}
	
			System.out.println("==전체정보가 출력되었습니다==");
		}////end of showAllData
	
		//친구정보 간략보기
		/*
		1. 고딩친구 정보를 Friend 추가
		2. High객체가 Friend타입으로 자동형변환되어 저장
		3. 객체배열에 저장된 객체들을 for문을 통해 순차적으로 출력
			이때 오버라이딩된 메소드를 통해 항상 해당 객체의 
			정보를 출력할수 있음. (참조변수의 타입에 영향을 
			받지않음)
		 */
		public void showSimpleData() {
			for(int i=0 ; i<numOfFriends ; i++) {
				myFriends[i].showBasicInfo();
			}
	
			System.out.println("==간략정보가 출력되었습니다==");
		}////end of showSimpleData
		
		
		//주소록 검색
		public void searchInfo() {
			Scanner scan = new Scanner(System.in);
			System.out.print("검색할 이름을 입력하세요:");
			String searchName = scan.nextLine();
	
			for(int i=0 ; i<numOfFriends ; i++) {			
				System.out.println("검색중인이름:"+ myFriends[i].name);
				
				//검색할 이름과 객체의 이름이 일치하는 경우 모든정보를 출력함
				if(searchName.compareTo(myFriends[i].name)==0) {
					myFriends[i].showAllData();
					System.out.println("**귀하가 요청하는 정보를 찾았습니다.**");
				}
			}
		}////end of searchInfo
	
		//주소록 항목 삭제
		public void deleteInfo() {
			Scanner scan = new Scanner(System.in);
			System.out.print("삭제할 이름을 입력하세요:");
			String deleteName = scan.nextLine();
			
			/*
			배열의 요소중 삭제된 요소의 인덱스값을 저장할 용도의변수.
			요소를 삭제한후 빈자리를 채울때 사용할 예정임.
			 */
			int deleteIndex = -1;
	
			for(int i=0 ; i<numOfFriends ; i++) {
				if(deleteName.compareTo(myFriends[i].name)==0) {
					//요소를 삭제하기 위해 참조값을 null로 변경
					myFriends[i] = null;
					//삭제된 요소의 인덱스값 저장
					deleteIndex = i;
					//전체카운트 변수 -1 차감
					numOfFriends--;
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
				for(int i=deleteIndex ; i<numOfFriends ; i++) {
					myFriends[i] = myFriends[i+1];
				}
				System.out.println("==데이터("+ deleteIndex
						+"번)가 삭제되었습니다==");
			}
		}////end of deleteInfo
		
		//친구정보를 파일형태로 저장하기
		public void saveFriendInfo() {
			
			try {
				ObjectOutputStream out = new ObjectOutputStream(
						new FileOutputStream("src/ex20io/friend_info.obj")
					);
				
				//myFriends 객체배열에 저장된 친구의 정보만큼 반복
				for(int i=0 ; i<numOfFriends ; i++) {
					//객체배열의 i번째 요소를 파일로 저장
					out.writeObject(myFriends[i]);
				}			
			}
			catch (Exception e) {
				System.out.println("예외발생");
				e.printStackTrace();
			}		
		}
}