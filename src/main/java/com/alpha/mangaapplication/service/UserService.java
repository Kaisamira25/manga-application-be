package com.alpha.mangaapplication.service;

import com.alpha.mangaapplication.model.User;

public interface UserService {
    User findByEmail(String email);
}
