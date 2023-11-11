package com.ssafy.enjoyTrip.model.service;

import com.ssafy.enjoyTrip.model.dto.User;
import com.ssafy.enjoyTrip.model.mapper.UserMapper;
import com.ssafy.enjoyTrip.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public String login(User user) {
        User loginUser = userMapper.login(user);

        if(loginUser == null) return null;
        return JWTUtil.generateToken(user);
    }

    public void register(User user) {
        user.setRole("user");
        userMapper.register(user);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(String id) {
        userMapper.delete(id);
    }
}
