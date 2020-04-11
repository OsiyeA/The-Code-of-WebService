package com.jbzhang.ws.jdkserver;

public class SayHelloServie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获取本地接口的代理对象
		HelloMyFirstServiceImpl helloService=new HelloMyFirstServiceImplService()
				.getHelloMyFirstServiceImplPort();
		System.out.println(helloService.getClass());
		//通过代理对象调用远程服务方法
		System.out.println(helloService.helloService("jbzhang"));

	}

}
