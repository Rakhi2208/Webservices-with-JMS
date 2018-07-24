package com.teamsankya.client.dto;

public class BankDetailsBean {

	private int cvv;
	private long accntNo;
	private String expiryDate;
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public long getAccntNo() {
		return accntNo;
	}
	public void setAccntNo(long accntNo) {
		this.accntNo = accntNo;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	
}
