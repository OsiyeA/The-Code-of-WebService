package com.jbzhang.ws.jdkserver;

import javax.xml.ws.Endpoint;

public class StartServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Endpoint是终端的意思。
		String address = "http://192.168.1.11:8888/hello";//发布地址
		Object implementor = new HelloMyFirstServiceImpl();//发布服务
		Endpoint.publish(address, implementor);//异步执行
		System.out.println("服务发布成功！");
	}

}
