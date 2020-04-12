package com.jbzhang.ws.cxfserver;


import java.util.List;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

public class AuthInfoInterceptor extends AbstractPhaseInterceptor<SoapMessage> {

	public AuthInfoInterceptor() {
		super(Phase.PRE_INVOKE); //���պ�ִ��ǰ
		// TODO Auto-generated constructor stub
	}
	//��soapͷ���л�ȡuserName��Password����Ȩ���ж�
	/**
	 *  <soap:Header>
    	<authInfo>
    		<userName>admin</userName>
    		<password>0</password>
    	</authInfo>
    </soap:Header>
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		// TODO Auto-generated method stub
		//��ȡ���е�Header
				List<Header> headers = message.getHeaders();
				if (headers == null || headers.size() < 1) {
					throw new Fault(new IllegalArgumentException("��Я���û���Ϣ��"));
				}
				
				//��ȡ��һ��Header
				Header authInfoHeader = headers.get(0);
				
				//��Header��ȡuserName��Password
				Element authInfoEle = (Element) authInfoHeader.getObject();
				String userName = authInfoEle.getElementsByTagName("userName")
						.item(0).getTextContent();
				String password = authInfoEle.getElementsByTagName("password")
						.item(0).getTextContent();
				//��Ȩ���ж�--������˵Ҫ����Ȩ��ģ�����ж��Ƿ���Ȩ�ޣ��������ڼ�һ�㣬ֻҪ������admin��0����Ϊ��Ȩ��
				if ("admin".equals(userName)&&"0".equals(password)) {
					return;//����ִ��
				}
				
				throw new Fault(new IllegalArgumentException("�û��������벻��ȷ��"));
	}

}
