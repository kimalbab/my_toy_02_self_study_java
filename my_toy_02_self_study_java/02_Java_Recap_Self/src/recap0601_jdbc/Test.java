package recap0601_jdbc;
import java.sql.Date;

public class Test {
	
	//field
	private int testNo;
	private String testName;
	private Date testDate; //java.sql.Date importing
	
	//기본생성자, 매개변수생성자, getter/setter, toString
	public Test() {
		
	}
	
	
	// 알트 쉬프트 에스 오 엔터
	public Test(int testNo, String testName, Date testDate) {
		super();
		this.testNo = testNo;
		this.testName = testName;
		this.testDate = testDate;
	}

	
	// 알트 쉬프트 에스 알 엔터 > 알트 에이 > 알트 알
	public int getTestNo() {
		return testNo;
	}


	public void setTestNo(int testNo) {
		this.testNo = testNo;
	}


	public String getTestName() {
		return testName;
	}


	public void setTestName(String testName) {
		this.testName = testName;
	}


	public Date getTestDate() {
		return testDate;
	}


	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}


	// 알트 쉬프트 에스 에스 엔터
	@Override
	public String toString() {
		return "Test [testNo=" + testNo + ", testName=" + testName + ", testDate=" + testDate + "]";
	}
	
	
	

	
	
	
	
}