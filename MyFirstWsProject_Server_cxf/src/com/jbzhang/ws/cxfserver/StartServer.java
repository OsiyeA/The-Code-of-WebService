package com.jbzhang.ws.cxfserver;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class StartServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.����JaxWsServerFactoryBean�Ķ������ڷ�������
				JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
				// 2.���÷��񷢲���ַ
				factoryBean.setAddress("http://192.168.1.11:8888/hello");
				// 3.���÷��񷢲��Ľӿ�
				factoryBean.setServiceClass(HelloMyFirstService.class);
				// 4.���÷���ķ�������
				factoryBean.setServiceBean(new HelloMyFirstServiceImpl());
				//===========������==============//
				factoryBean.getInInterceptors().add(new LoggingInInterceptor());
				factoryBean.getInInterceptors().add(new AuthInfoInterceptor());
				//factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
				//===========������==============//
				// 5.ʹ��create������������
				factoryBean.create();
				System.out.println("��������ɹ���");
	}

}
