package com.ssafy.enjoyTrip.web.user.controller;

import com.ssafy.enjoyTrip.model.user.response.TokenResponse;
import com.ssafy.enjoyTrip.model.user.service.UserService;
import com.ssafy.enjoyTrip.web.user.dtoMapper.UserDtoMapper;
import com.ssafy.enjoyTrip.web.user.payload.UserLogin;
import com.ssafy.enjoyTrip.web.user.payload.UserRegister;
import com.ssafy.enjoyTrip.web.user.payload.UserUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserDtoMapper userDtoMapper;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLogin userLogin) {
        TokenResponse tokenResponse = userService.login(userDtoMapper.userLoginToDto(userLogin));

        if(tokenResponse == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        return ResponseEntity.ok(tokenResponse);
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody UserRegister userRegister) {
        userService.register(userDtoMapper.userRegisterToDto(userRegister));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> update(@PathVariable String userId, @RequestBody UserUpdate userUpdate) {
        userService.update(userDtoMapper.userUpdateToDto(userId, userUpdate));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable String userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
}