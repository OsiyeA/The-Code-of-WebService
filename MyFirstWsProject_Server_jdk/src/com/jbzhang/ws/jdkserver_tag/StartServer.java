package com.jbzhang.ws.jdkserver_tag;

import javax.xml.ws.Endpoint;

import com.jbzhang.ws.jdkserver.HelloMyFirstServiceImpl;

public class StartServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String address = "http://192.168.1.11:8888/hi";//������ַ
		Object implementor = new HiMyFirstServiceImpl();//��������
		Endpoint.publish(address, implementor);//�첽ִ��
		System.out.println("���񷢲��ɹ���");

	}

}
