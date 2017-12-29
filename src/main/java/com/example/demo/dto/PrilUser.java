package com.example.demo.dto;

import java.security.Principal;

/**
 * Created by zhangzhili on 2017/12/29.
 */
public class PrilUser implements Principal {

    private String userName;


    public PrilUser(String userName){
        this.userName = userName;
    }


    @Override
    public String getName() {
        return userName;
    }
}
