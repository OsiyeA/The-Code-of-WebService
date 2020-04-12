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
		super(Phase.PRE_INVOKE); //接收后，执行前
		// TODO Auto-generated constructor stub
	}
	//从soap头部中获取userName和Password来做权限判断
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
		//获取所有的Header
				List<Header> headers = message.getHeaders();
				if (headers == null || headers.size() < 1) {
					throw new Fault(new IllegalArgumentException("请携带用户信息！"));
				}
				
				//获取第一个Header
				Header authInfoHeader = headers.get(0);
				
				//从Header获取userName和Password
				Element authInfoEle = (Element) authInfoHeader.getObject();
				String userName = authInfoEle.getElementsByTagName("userName")
						.item(0).getTextContent();
				String password = authInfoEle.getElementsByTagName("password")
						.item(0).getTextContent();
				//做权限判断--正常来说要调用权限模块来判断是否有权限，但是现在简单一点，只要输入是admin和0就认为有权限
				if ("admin".equals(userName)&&"0".equals(password)) {
					return;//正常执行
				}
				
				throw new Fault(new IllegalArgumentException("用户名或密码不正确！"));
	}

}
