package com.jbzhang.ws.jdkserver;

import javax.xml.ws.Endpoint;

public class StartServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Endpoint���ն˵���˼��
		String address = "http://192.168.1.11:8888/hello";//������ַ
		Object implementor = new HelloMyFirstServiceImpl();//��������
		Endpoint.publish(address, implementor);//�첽ִ��
		System.out.println("���񷢲��ɹ���");
	}

}
