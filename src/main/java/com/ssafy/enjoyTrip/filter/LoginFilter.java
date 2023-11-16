package com.ssafy.enjoyTrip.filter;

import com.ssafy.enjoyTrip.util.JWTUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String authorizationHeader = httpRequest.getHeader("Authorization");

        if(httpRequest.getRequestURI().startsWith("/api/user")) {
            String method = httpRequest.getMethod();
            if(method.equals("GET") || method.equals("POST")) {
                chain.doFilter(request, response);
                return;
            }
        }

        if(authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        String token = authorizationHeader.substring(7); //"Bearer "이후의 토큰 추출
        try {
            JWTUtil.validateToken(token);
        } catch (Exception e) {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        String userId = JWTUtil.getUserId(token);
        if(httpRequest.getRequestURI().startsWith("/api/admin") && !userId.equals("admin")) {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        request.setAttribute("userId", userId);
        chain.doFilter(request, response);
    }
}
