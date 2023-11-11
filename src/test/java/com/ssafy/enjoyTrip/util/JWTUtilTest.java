package com.ssafy.enjoyTrip.util;

import com.ssafy.enjoyTrip.model.dto.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.junit.jupiter.api.Test;

import static com.ssafy.enjoyTrip.util.JWTUtil.decodeToken;
import static com.ssafy.enjoyTrip.util.JWTUtil.validateToken;
import static org.assertj.core.api.Assertions.assertThat;

class JWTUtilTest {
    @Test
    void testJWT() {
        User user = new User();
        user.setId("ssafy");
        user.setPw("ssafy");

        //토큰 생성
        String token = JWTUtil.generateToken(user);
        System.out.println("생성된 토큰 : " + token);

        //토큰 디코딩
        String decoded = decodeToken(token);
        System.out.println("디코딩된 토큰 : " + decoded);

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