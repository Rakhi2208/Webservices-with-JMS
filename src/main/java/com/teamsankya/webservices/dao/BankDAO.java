package com.teamsankya.webservices.dao;

import com.teamsankya.webservices.dto.BankDetailsBean;

public class BankDAO {
	
	public boolean checkCredentials(BankDetailsBean bean) {
		if(bean.getAccntNo()==12345678912l && bean.getCvv()==123
				&& bean.getExpiryDate().equals("12/12")) {
			
			return true;
		}else {
			return false;
		}
	}
}
