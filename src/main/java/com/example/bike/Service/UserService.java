package com.example.bike.Service;

import com.example.bike.Entity.User;

public interface UserService {
    boolean senMsg(String countryCode, String phoneNum);

    boolean verify(String phoneNum, String verifyCode);

    void register(User user);

    void update(User user);
}
