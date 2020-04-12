package com.jbzhang.ws.cxfserver;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class StartServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1.创建JaxWsServerFactoryBean的对象，用于发布服务
				JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
				// 2.设置服务发布地址
				factoryBean.setAddress("http://192.168.1.11:8888/hello");
				// 3.设置服务发布的接口
				factoryBean.setServiceClass(HelloMyFirstService.class);
				// 4.设置服务的发布对象
				factoryBean.setServiceBean(new HelloMyFirstServiceImpl());
				//===========拦截器==============//
				factoryBean.getInInterceptors().add(new LoggingInInterceptor());
				factoryBean.getInInterceptors().add(new AuthInfoInterceptor());
				//factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
				//===========拦截器==============//
				// 5.使用create方法发布服务
				factoryBean.create();
				System.out.println("发布服务成功！");
	}

}
