package com.jbzhang.ws.cxfclient;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AuthInfoOutInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
	private String name;
	private String password;
	public AuthInfoOutInterceptor(String name,String password) {
		super(Phase.PREPARE_SEND);//���ý׶�
		// TODO Auto-generated constructor stub
		this.name = name;
		this.password = password;
	}
	/**
	 *  <soap:Header>
    	<authInfo>
    		<userName>jbzhang</userName>
    		<password>0</password>
    	</authInfo>
    </soap:Header>
	 */
	@Override
	public void handleMessage(SoapMessage message) throws Fault {
		// TODO Auto-generated method stub
		//namespaceURI ����ռ�uri
				//prefix ǰ׺
				//localPart ����д
				QName q = new QName("jbzhang");//�޶��� <authInfo></authInfo>
				//QName q = new QName(namespaceURI, localPart)//�޶��� <authInfo xmlns:ns2="http://yaohauiepng.org/></authInfo>
				//QName q = new QName(namespaceURI, localPart, prefix)//�޶��� <yhptest:authInfo xmlns:ns2="http://yaohauiepng.org/></authInfo>
				
				//����authInfoԪ�ؽڵ�
				Document document = DOMUtils.createDocument();
				Element authInfoEle = document.createElement("authInfo");
				
				//����ӽڵ�
				Element userNameEle = document.createElement("userName");
				userNameEle.setTextContent(name);
				authInfoEle.appendChild(userNameEle);
				
				Element passwordEle = document.createElement("password");
				passwordEle.setTextContent(password);
				authInfoEle.appendChild(passwordEle);
		//���ȹ���һ��<soap:Header>
				Header authInHeader = new Header(q, authInfoEle);
				//������Ϊһ��Header,���header�ļ�����
				message.getHeaders().add(authInHeader);
	}
 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
