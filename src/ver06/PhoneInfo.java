package ver06;

import java.util.Scanner;

public class PhoneInfo {
	// 멤버변수
	private String name;
	private String phoneNumber;	

	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	// 정보출력용 메소드
	public void dataAllShow() {
		System.out.println("이름 :" + name);
		
		System.out.println("전화번호 :" + phoneNumber);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
