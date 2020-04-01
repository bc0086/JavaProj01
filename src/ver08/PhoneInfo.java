package ver08;

import java.io.Serializable;
import java.util.Scanner;

public class PhoneInfo implements Serializable	{
	// 멤버변수
	String name;
	String phoneNumber;

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

	
	@Override
	public String toString() {
		return "이름=" + name + ", 전화번호=" + phoneNumber;
	}

	@Override
	public int hashCode() {
		int hc1 = name.hashCode();
		//System.out.println(hc1);
		int result = hc1;		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// 형변환
		PhoneInfo phoneinfo = (PhoneInfo) obj;
		if (phoneinfo.name.equals(this.name)) {
			return true;
		} 
		else {
			return false;
		}
	}
}



