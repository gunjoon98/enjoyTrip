package com.ssafy.enjoyTrip.model.user.mapper;

import com.ssafy.enjoyTrip.model.user.dto.UserLoginDto;
import com.ssafy.enjoyTrip.model.user.dto.UserRegisterDto;
import com.ssafy.enjoyTrip.model.user.dto.UserUpdateDto;
import com.ssafy.enjoyTrip.model.user.response.UserResponse;

public interface UserMapper {
    UserResponse login(UserLoginDto userLoginDto);
    int register(UserRegisterDto userRegisterDto);
    int update(UserUpdateDto userUpdateDto);
    int delete(String id);
}
