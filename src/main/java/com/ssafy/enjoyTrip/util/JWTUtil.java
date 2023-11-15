package com.ssafy.enjoyTrip.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.enjoyTrip.model.dto.User;
import com.ssafy.enjoyTrip.model.exception.JWTException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;
import java.util.Map;

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

    public static String GetUserIdByToken(String token) {
        Base64.Decoder decoder = Base64.getDecoder();
        String[] splitToken = token.split("\\.");
        String json = new String(decoder.decode(splitToken[1]));

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Map<String, Object> map = objectMapper.readValue(json, Map.class);
            return (String) map.get("id");
        }
        catch (JsonProcessingException e) {
            throw new JWTException(e);
        }
    }
}
