package com.jbzhang.ws.jdkserver_tag;

import javax.jws.WebService;

/**
 * @WebService��ʶ��һ��Զ�̷�����
 *    endpointInterface�ӿڣ������˸����Խӿ�����ҲҪ����webService
 *     ,serviceName="helloService", ������
		portName="helloServicePort", �˿���
		targetNamespace="http://yaohuaipeng.org" �޶�����ʵ������˽ӿ�ҲҪ���Ÿ�
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
