package com.integretion.http;

import com.integretion.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

public class EndPoint {

    @Autowired
    private ApplicationContext applicationContext;

    public void printOut() {
        System.out.println("你好世界");
    }
}
