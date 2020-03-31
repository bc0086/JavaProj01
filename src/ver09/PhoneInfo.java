package ver09;

import java.util.Scanner;

public class PhoneInfo {
	// 멤버변수
	private String name;
	String phoneNumber;
	String birthday;

	// 생성자
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		super();
		this.setName(name);
		this.phoneNumber = phoneNumber;
		this.birthday = birthday;
	}

	// 생년월일은 필수사항 아니므로 인자가 없는 경우 null로 초기화
	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.setName(name);
		this.phoneNumber = phoneNumber;
		this.birthday = null;
	}

	// 정보출력용 메소드
	public void dataAllShow() {
		System.out.println("이름 :" + getName());
		
		System.out.println("전화번호 :" + phoneNumber);
		
		if (birthday.equals("")) {
			System.out.println("생년월일 입력되지 않음");
		} 
		
		else {
			System.out.println("생년월일 :" + birthday);
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
