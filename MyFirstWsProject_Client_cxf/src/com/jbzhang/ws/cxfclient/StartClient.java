package com.jbzhang.ws.cxfclient;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class StartClient {
	public static void main(String[] args) {
		// 1.����JaxWsProxyFactoryBean�Ķ������ڽ��շ���
				JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
				// 2.���÷���ķ�����ַ����ʾȥ�����ȥ����
				bean.setAddress("http://192.168.1.11:8888/hello");
				// 3.���÷���ķ����ӿڣ�ʹ�ñ��صĴ���ӿ�
				bean.setServiceClass(HelloMyFirstService.class);
				//==============������=====================//
				bean.getOutInterceptors().add(new LoggingOutInterceptor());//
				bean.getOutInterceptors().add(new AuthInfoOutInterceptor("admin","0"));

				//bean.getInInterceptors().add(new LoggingInInterceptor());
				//==============������=====================//
				// 4.ͨ��create�������ؽӿڴ���ʵ��
				HelloMyFirstService helloService = (HelloMyFirstService) bean.create();
				System.out.println(helloService.getClass());
				// 5.����Զ�̷���
				System.out.println(helloService.hello("jbzhang"));
	}

}
