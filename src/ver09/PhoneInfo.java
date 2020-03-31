package ver09;

import java.util.Scanner;

public class PhoneInfo {
	// 멤버변수
	private String name;
	private String phoneNumber;
	private String birthday;

	// 생성자
	public PhoneInfo(String name, String phoneNumber, String birthday) {
		super();
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setBirthday(birthday);
	}	
	
	public PhoneInfo(String name, String phoneNumber) {
		super();
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setBirthday(null);
	}	

	// 정보출력용 메소드
	public void dataAllShow() {
		System.out.println("이름 :" + getName());
		
		System.out.println("전화번호 :" + getPhoneNumber());
		
		if (birthday.equals("")) {
			System.out.println("생년월일 입력되지 않음");
		} 
		
		else {
			System.out.println("생년월일 :" + getBirthday());
		}

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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
}
