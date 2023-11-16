package com.ssafy.enjoyTrip.util;

import com.ssafy.enjoyTrip.model.dto.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static com.ssafy.enjoyTrip.util.JWTUtil.validateToken;
import static org.assertj.core.api.Assertions.assertThat;

class JWTUtilTest {
    @Test
    void testJWT() {
        User user = new User();
        user.setId("ssafy");
        user.setPw("ssafy");
        user.setRole("user");

        //토큰 생성
        String token = JWTUtil.generateToken(user);
        System.out.println("생성된 토큰 : " + token);

        //토큰 디코딩
        String id = JWTUtil.getUserId(token);
        System.out.println("유저 id : " + id);

        //유효성 검증
        try {
            Jws<Claims> parsedToken = validateToken(token);
            System.out.println("Body: " + parsedToken.getBody());
            System.out.println("유효한 토큰");
        } catch (Exception e) {
            System.out.println("유효하지 않거나 만료된 토큰.");
        }
    }
}