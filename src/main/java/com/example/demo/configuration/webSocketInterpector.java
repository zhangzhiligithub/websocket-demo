package com.example.demo.configuration;

import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Collection;
import java.util.Map;

/**
 * Created by zhangzhili on 2017/12/28.
 */
public class webSocketInterpector extends HttpSessionHandshakeInterceptor {

    public webSocketInterpector() {

        super();
        System.out.println(111);
    }

    public webSocketInterpector(Collection<String> attributeNames) {
        super(attributeNames);
        System.out.println(222);
    }

    @Override
    public Collection<String> getAttributeNames() {
        System.out.println(333);
        return super.getAttributeNames();
    }

    @Override
    public void setCopyAllAttributes(boolean copyAllAttributes) {
        System.out.println(444);
        super.setCopyAllAttributes(copyAllAttributes);
    }

    @Override
    public boolean isCopyAllAttributes() {
        System.out.println(555);
        return super.isCopyAllAttributes();
    }

    @Override
    public void setCopyHttpSessionId(boolean copyHttpSessionId) {
        System.out.println(666);
        super.setCopyHttpSessionId(copyHttpSessionId);
    }

    @Override
    public boolean isCopyHttpSessionId() {
        System.out.println(777);
        return super.isCopyHttpSessionId();
    }

    @Override
    public void setCreateSession(boolean createSession) {
        System.out.println(888);
        super.setCreateSession(createSession);
    }

    @Override
    public boolean isCreateSession() {
        System.out.println(999);
        return super.isCreateSession();
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
       return super.beforeHandshake(request,response,wsHandler,attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                               WebSocketHandler wsHandler, Exception ex) {

        super.afterHandshake(request, response, wsHandler, ex);
    }
}
