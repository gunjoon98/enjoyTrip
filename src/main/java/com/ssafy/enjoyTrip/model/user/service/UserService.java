package com.ssafy.enjoyTrip.model.user.service;

import com.ssafy.enjoyTrip.model.user.dto.UserLoginDto;
import com.ssafy.enjoyTrip.model.user.dto.UserRegisterDto;
import com.ssafy.enjoyTrip.model.user.dto.UserUpdateDto;
import com.ssafy.enjoyTrip.model.user.mapper.UserMapper;
import com.ssafy.enjoyTrip.model.user.response.TokenResponse;
import com.ssafy.enjoyTrip.model.user.response.UserResponse;
import com.ssafy.enjoyTrip.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public TokenResponse login(UserLoginDto userLoginDto) {
        UserResponse loginUser = userMapper.login(userLoginDto);

        if(loginUser == null) return null;
        return new TokenResponse(JWTUtil.generateToken(loginUser.getId(), loginUser.getName(), loginUser.getRole()));
    }

    public void register(UserRegisterDto userRegisterDto) {
        userMapper.register(userRegisterDto);
    }

    public void update(UserUpdateDto userUpdateDto) {
        userMapper.update(userUpdateDto);
    }

    public void delete(String id) {
        userMapper.delete(id);
    }
}
