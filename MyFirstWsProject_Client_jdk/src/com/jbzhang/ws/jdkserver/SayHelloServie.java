package com.jbzhang.ws.jdkserver;

public class SayHelloServie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��ȡ���ؽӿڵĴ������
		HelloMyFirstServiceImpl helloService=new HelloMyFirstServiceImplService()
				.getHelloMyFirstServiceImplPort();
		System.out.println(helloService.getClass());
		//ͨ������������Զ�̷��񷽷�
		System.out.println(helloService.helloService("jbzhang"));

	}

}
