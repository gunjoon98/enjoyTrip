package com.ssafy.enjoyTrip.web.user.dtoMapper;

import com.ssafy.enjoyTrip.model.user.dto.*;
import com.ssafy.enjoyTrip.web.user.payload.UserLogin;
import com.ssafy.enjoyTrip.web.user.payload.UserRegister;
import com.ssafy.enjoyTrip.web.user.payload.UserUpdate;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public UserLoginDto userLoginToDto(UserLogin userLogin) {
        return new UserLoginDto(userLogin.getId(), userLogin.getPw());
    }

    public UserRegisterDto userRegisterToDto(UserRegister userRegister) {
        return new UserRegisterDto(
                userRegister.getId(),
                userRegister.getPw(),
                userRegister.getEmail(),
                userRegister.getName(),
                "user");
    }

    public UserUpdateDto userUpdateToDto(String id, UserUpdate userUpdate) {
        return new UserUpdateDto(id, userUpdate.getPw(), userUpdate.getName());
    }
}
