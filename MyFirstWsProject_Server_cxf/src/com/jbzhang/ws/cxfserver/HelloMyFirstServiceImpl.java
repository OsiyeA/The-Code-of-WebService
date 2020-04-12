package com.jbzhang.ws.cxfserver;

import javax.jws.WebService;

@WebService(endpointInterface="com.jbzhang.ws.cxfserver.HelloMyFirstService")
public class HelloMyFirstServiceImpl implements HelloMyFirstService {

	@Override
	public String Hello(String name) {
		// TODO Auto-generated method stub
		return name +"say Hello My First Service!";
	}

}
