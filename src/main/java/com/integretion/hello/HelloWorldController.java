package com.integretion.hello;

import com.integretion.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    private static Log logger = LogFactory.getLog(HelloWorldController.class);


    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/test")
    public void test() {
        MessageChannel inputChannel = applicationContext.getBean("inputChannel", MessageChannel.class);
        PollableChannel outputChannel = applicationContext.getBean("outputChannel", PollableChannel.class);

        // 由输入通道发送消息
        Message<String> message0 = new GenericMessage<>("World");
        inputChannel.send(message0);

        // 轮询通道接收消息
        Message<User> receive0 = (Message<User>) outputChannel.receive(0);
        User payload0 = receive0.getPayload();
        logger.info("========================================> HelloWorldDemo: " + payload0);
    }

/*    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/hello/helloWorldDemo.xml", HelloWorldController.class);
        MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
        PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);

        // 由输入通道发送消息
        Message<String> message0 = new GenericMessage<>("World");
        inputChannel.send(message0);

        Message<String> message1 = new GenericMessage<>("Game");
        inputChannel.send(message1);

//
//		Message<String> message2 = new GenericMessage<>("Earth");
//		inputChannel.send(message2);

        // 轮询通道接收消息
        Message<User> receive0 = (Message<User>) outputChannel.receive(0);
        User payload0 = receive0.getPayload();
        logger.info("========================================> HelloWorldDemo: " + payload0);

        Message<User> receive1 = (Message<User>) outputChannel.receive(1);
        User payload1 = receive1.getPayload();
        logger.info("######################################### HelloWorldDemo: " + payload1);
//
//		Message<User> receive2 = (Message<User>)outputChannel.receive(2);
//		User payload2 = receive2.getPayload();
//		logger.info("***************************************** HelloWorldDemo: " + payload2);

        context.close();
    }*/

}
