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
		super(Phase.PREPARE_SEND);//设置阶段
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
		//namespaceURI 命令空间uri
				//prefix 前缀
				//localPart 随意写
				QName q = new QName("jbzhang");//限定名 <authInfo></authInfo>
				//QName q = new QName(namespaceURI, localPart)//限定名 <authInfo xmlns:ns2="http://yaohauiepng.org/></authInfo>
				//QName q = new QName(namespaceURI, localPart, prefix)//限定名 <yhptest:authInfo xmlns:ns2="http://yaohauiepng.org/></authInfo>
				
				//创建authInfo元素节点
				Document document = DOMUtils.createDocument();
				Element authInfoEle = document.createElement("authInfo");
				
				//添加子节点
				Element userNameEle = document.createElement("userName");
				userNameEle.setTextContent(name);
				authInfoEle.appendChild(userNameEle);
				
				Element passwordEle = document.createElement("password");
				passwordEle.setTextContent(password);
				authInfoEle.appendChild(passwordEle);
		//首先构造一个<soap:Header>
				Header authInHeader = new Header(q, authInfoEle);
				//把它作为一个Header,添加header的集合中
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
