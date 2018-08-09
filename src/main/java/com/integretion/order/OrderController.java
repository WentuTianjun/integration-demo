package com.integretion.order;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liuchen25 on 2018/8/7.
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static Log logger = LogFactory.getLog(OrderController.class);

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/test")
    public String getName() {
        return "小王";
    }
}
