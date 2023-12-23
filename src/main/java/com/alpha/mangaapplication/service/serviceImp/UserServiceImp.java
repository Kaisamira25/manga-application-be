package com.alpha.mangaapplication.service.serviceImp;

import com.alpha.mangaapplication.model.User;
import com.alpha.mangaapplication.repository.UserRepository;
import com.alpha.mangaapplication.service.CreateAndUpdateService;
import com.alpha.mangaapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService, CreateAndUpdateService<Integer,User> {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Object create(User value) {
        return userRepository.save(value);
    }

    @Override
    public User update(Integer id, User value) {
        return null;
    }
}
