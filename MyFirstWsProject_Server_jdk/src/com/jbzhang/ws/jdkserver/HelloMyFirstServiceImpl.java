package com.jbzhang.ws.jdkserver;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloMyFirstServiceImpl {
	@WebMethod
	public String helloService(String name){
		return name +"say: hello my first webservice!";
	}
}
