package com.teamsankya.webservices.rootclasses;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.teamsankya.webservices.dao.BankDAO;
import com.teamsankya.webservices.dto.BankDetailsBean;
import com.teamsankya.webservices.dto.ResponseGenerator;

@Path("/bank")
public class BankRestApiJson {
	
	
	@POST
	@Path("check")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseGenerator check(BankDetailsBean bean) {
		BankDAO dao = new BankDAO();
		ResponseGenerator generator = new ResponseGenerator();
		if(dao.checkCredentials(bean)) {
			generator.setStatusCode(201);
			generator.setMessage("Payment Status");
			generator.setDescription("Payment scuccessfully done");
		}else {
			generator.setStatusCode(401);
			generator.setMessage("Payment Status");
			generator.setDescription("Unsuccessfull");
		}
		return generator;
	}
}
