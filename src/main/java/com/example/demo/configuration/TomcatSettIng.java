package com.example.demo.configuration;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by zhangzhili on 2017/12/29.
 */
@Component
public class TomcatSettIng extends TomcatEmbeddedServletContainerFactory {


    protected void customizeConnector(Connector connector) {
        super.customizeConnector(connector);
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        System.out.println(protocol.getMaxHttpHeaderSize());
        protocol.setMaxHttpHeaderSize(81920);
    }
}
