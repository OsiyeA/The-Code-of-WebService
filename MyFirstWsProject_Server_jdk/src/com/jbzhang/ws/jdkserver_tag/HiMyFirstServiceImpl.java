package com.jbzhang.ws.jdkserver_tag;

import javax.jws.WebService;

/**
 * @WebService标识是一个远程服务类
 *    endpointInterface接口，配置了该属性接口上面也要配置webService
 *     ,serviceName="helloService", 服务名
		portName="helloServicePort", 端口名
		targetNamespace="http://yaohuaipeng.org" 限定名，实现类改了接口也要跟着改
 * @author Administrator
 *
 */
@WebService(
		endpointInterface="com.jbzhang.ws.jdkserver_tag.HiMyFirstService"
		,serviceName="hiService",
		portName="hiServicePort",
		targetNamespace="http://jbzhang.org"
		)
public class HiMyFirstServiceImpl implements HiMyFirstService {

	@Override
	public String sayHi(String name) {
		// TODO Auto-generated method stub
		return name+" Hi My second service!";
	}

	@Override
	public String sayHi1(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
