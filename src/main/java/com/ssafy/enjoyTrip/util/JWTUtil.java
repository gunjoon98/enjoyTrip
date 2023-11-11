package com.ssafy.enjoyTrip.util;

import com.ssafy.enjoyTrip.model.dto.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;

public class JWTUtil {
    private static final String SECRET_KEY = "ssafy";
    private static final long EXPIRATION_SECOND = 60 * 60 * 2;

    public static String generateToken(User user) {
        long now = System.currentTimeMillis();
        long expirationSecond = 60 * 60 * 2; //2시간

        Claims claims = Jwts.claims();
        claims.put("id", user.getId());
        claims.put("name", user.getName());
        claims.put("role", user.getRole());

        //토큰 생성
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(now + 1000 * expirationSecond))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Jws<Claims> validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token);
    }

    public static String decodeToken(String token) {
        String[] splitToken = token.split("\\.");
        String body = splitToken[1];

        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(body));
    }
}
