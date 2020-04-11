package com.jbzhang.ws.jdkserver_tag;

import javax.xml.ws.Endpoint;

import com.jbzhang.ws.jdkserver.HelloMyFirstServiceImpl;

public class StartServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String address = "http://192.168.1.11:8888/hi";//发布地址
		Object implementor = new HiMyFirstServiceImpl();//发布服务
		Endpoint.publish(address, implementor);//异步执行
		System.out.println("服务发布成功！");

	}

}
