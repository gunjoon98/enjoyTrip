package com.ssafy.enjoyTrip.model.mapper;

import com.ssafy.enjoyTrip.model.dto.User;

public interface UserMapper {
    User login(User user);
    int register(User user);
    int update(User user);
    int delete(String id);
}
