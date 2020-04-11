package com.jbzhang.ws.jdkserver_tag;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @WebMethod：
 *   只要你在某接口上添加了@WebService，name在所有的方法上面都会加上@WebMethod
 *    operationName="sayHello" 改暴露的方法名
 *    exclude=true 排除方法
 * @WebParam(name="name") 改参数名称
 * @WebResult(name="ret") 改返回值名称
 * @author Administrator
 *
 */
@WebService(targetNamespace="http://jbzhang.org")
@SOAPBinding(style=Style.RPC)//默认是document,rpc少了一些类型
public interface HiMyFirstService {
	@WebMethod
	//String sayHi(String name);
	@WebResult(name="ret")String sayHi(@WebParam(name="name")String name);

	@WebMethod(operationName="sayHello",exclude=true)
	String sayHi1(String name);


}
