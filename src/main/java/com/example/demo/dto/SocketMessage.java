package com.example.demo.dto;

/**
 * Created by zhangzhili on 2017/12/27.
 */
public class SocketMessage {

    public String responseMessage;

    public String date;

    @Override
    public String toString() {
        return "SocketMessage{" + "message='" + responseMessage + '\'' + ", date='" + date + '\'' + '}';
    }
}
