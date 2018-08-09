package com.integretion.hello;

import com.integretion.domain.User;
import org.springframework.stereotype.Service;

/**
 * Created by liuchen25 on 2018/8/6.
 */
@Service
public class UserService {

    public String getName(String query) {
        return "小王" + query;
    }


    public User getUser(String userId) {
        User user = new User();
        user.setId(userId);
        user.setName("嚣张");
        return user;
    }
}
