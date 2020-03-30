package ver09;

import java.io.Serializable;

public class PhoneCompanyInfo extends PhoneInfo   {
	String emp; //회사명
	
	public PhoneCompanyInfo(String name, String phoneNumber, String emp) {
		super(name, phoneNumber);
		this.emp = emp;
	}	
	
	@Override
	public void dataAllShow() {
		super.dataAllShow();
		System.out.println("회사명:"+ emp);
	}
	
	@Override
	public String toString() {		
		return super.toString() + ", 회사명= " + emp;
	}

}