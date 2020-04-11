package com.jbzhang.ws.jdkserver_tag;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @WebMethod��
 *   ֻҪ����ĳ�ӿ��������@WebService��name�����еķ������涼�����@WebMethod
 *    operationName="sayHello" �ı�¶�ķ�����
 *    exclude=true �ų�����
 * @WebParam(name="name") �Ĳ�������
 * @WebResult(name="ret") �ķ���ֵ����
 * @author Administrator
 *
 */
@WebService(targetNamespace="http://jbzhang.org")
@SOAPBinding(style=Style.RPC)//Ĭ����document,rpc����һЩ����
public interface HiMyFirstService {
	@WebMethod
	//String sayHi(String name);
	@WebResult(name="ret")String sayHi(@WebParam(name="name")String name);

	@WebMethod(operationName="sayHello",exclude=true)
	String sayHi1(String name);


}
