package com.example.demo.controller;

import com.example.demo.dto.SocketMessage;
import com.example.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangzhili on 2017/12/27.
 */
@Controller
public class MessageController {


    @Autowired
    private SimpMessagingTemplate template;



    @MessageMapping("user")
    public User sendMessage(User user) {
        user.setAge(90);
        return user;
    }

    @MessageMapping("/send.{id}")
    @SendToUser(value = "/ccc/send")
    public SocketMessage send(SocketMessage message, @DestinationVariable String id) throws Exception {
        // System.out.println("session.getId="+request.getSession().getId());
        System.out.println(message);

        System.out.println("id:=" + id);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.date = df.format(new Date());
        return message;
    }

    @GetMapping("/send")
    @ResponseBody
    public String send(String message,String sessId) throws Exception {
        SocketMessage socketMessage = new SocketMessage();
        socketMessage.responseMessage="哈哈哈";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        socketMessage.date = df.format(new Date());
        template.convertAndSendToUser(message,"/ccc/send",socketMessage,createHeaders(sessId));
        return "1";
    }
    private MessageHeaders createHeaders(String sessionId) {
        SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        return headerAccessor.getMessageHeaders();
    }
}
