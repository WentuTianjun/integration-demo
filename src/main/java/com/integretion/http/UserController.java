package com.integretion.http;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuchen25 on 2018/8/9.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getName")
    public void getName(String userId){
        System.out.println("UserController: getName " + userId);
    }
}
