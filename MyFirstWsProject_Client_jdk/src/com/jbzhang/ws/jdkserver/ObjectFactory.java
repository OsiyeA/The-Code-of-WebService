
package com.jbzhang.ws.jdkserver;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.jbzhang.ws.jdkserver package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _HelloServiceResponse_QNAME = new QName("http://jdkserver.ws.jbzhang.com/", "helloServiceResponse");
    private final static QName _HelloService_QNAME = new QName("http://jdkserver.ws.jbzhang.com/", "helloService");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.jbzhang.ws.jdkserver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HelloServiceResponse }
     * 
     */
    public HelloServiceResponse createHelloServiceResponse() {
        return new HelloServiceResponse();
    }

    /**
     * Create an instance of {@link HelloService }
     * 
     */
    public HelloService createHelloService() {
        return new HelloService();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloServiceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jdkserver.ws.jbzhang.com/", name = "helloServiceResponse")
    public JAXBElement<HelloServiceResponse> createHelloServiceResponse(HelloServiceResponse value) {
        return new JAXBElement<HelloServiceResponse>(_HelloServiceResponse_QNAME, HelloServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloService }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jdkserver.ws.jbzhang.com/", name = "helloService")
    public JAXBElement<HelloService> createHelloService(HelloService value) {
        return new JAXBElement<HelloService>(_HelloService_QNAME, HelloService.class, null, value);
    }

}
