package com.jbzhang.ws.cxfclient;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class StartClient {
	public static void main(String[] args) {
		// 1.创建JaxWsProxyFactoryBean的对象，用于接收服务
				JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
				// 2.设置服务的发布地址，表示去哪里过去服务
				bean.setAddress("http://192.168.1.11:8888/hello");
				// 3.设置服务的发布接口，使用本地的代理接口
				bean.setServiceClass(HelloMyFirstService.class);
				//==============拦截器=====================//
				bean.getOutInterceptors().add(new LoggingOutInterceptor());//
				bean.getOutInterceptors().add(new AuthInfoOutInterceptor("admin","0"));

				//bean.getInInterceptors().add(new LoggingInInterceptor());
				//==============拦截器=====================//
				// 4.通过create方法返回接口代理实例
				HelloMyFirstService helloService = (HelloMyFirstService) bean.create();
				System.out.println(helloService.getClass());
				// 5.调用远程方法
				System.out.println(helloService.hello("jbzhang"));
	}

}
