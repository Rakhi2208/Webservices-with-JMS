package com.teamsankya.client.controller;

import javax.jms.JMSException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.teamsankya.client.dto.BankDetailsBean;
import com.teamsankya.client.jmsproducer.JMSProducer;

public class BankController {
	
	public static void bookStudent(BankDetailsBean bean) throws JMSException {
		JMSProducer producer = new JMSProducer();
		
		//1. get the client
    	Client client = ClientBuilder.newClient();
    	
    	//2.get the target through client
    	WebTarget target = client.target("http://localhost:8081/webservicesproducer/api/bank/check");
    	
    	//3.get the response
    	Response response = target.request().accept(MediaType.APPLICATION_JSON).post(Entity.json(bean));
   
    	//4.process the response
    	System.out.println(".................");
    	producer.produce(response.readEntity(String.class));
    	//map.addAttribute("response", response.readEntity(ResponseGenerator.class));
		
		
	}
	public static void main(String[] args) throws JMSException {
		BankDetailsBean detailsBean = new BankDetailsBean();
		detailsBean.setAccntNo(12345678912l);
		detailsBean.setCvv(123);
		detailsBean.setExpiryDate("12/12");
		bookStudent(detailsBean);
	}
}
