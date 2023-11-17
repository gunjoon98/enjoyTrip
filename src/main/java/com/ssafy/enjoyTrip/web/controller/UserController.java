package com.ssafy.enjoyTrip.web.controller;

import com.ssafy.enjoyTrip.model.dto.User;
import com.ssafy.enjoyTrip.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Map<String, Object> responseMap = userService.login(user);

        if(responseMap == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        return ResponseEntity.ok(responseMap);
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> update(@PathVariable String userId, @RequestBody User user) {
        user.setId(userId);
        userService.update(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable String userId) {
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }
}
