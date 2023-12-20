package com.alpha.mangaapplication.utilities.CustomUser;

import com.alpha.mangaapplication.model.User;
import com.alpha.mangaapplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (username != null){
            return new CustomUserDetails(user);
        }
        log.error("-----> CustomerUserDetailsService: loadUserByUsername got the error: not found email: {}",user.getEmail());
        throw new UsernameNotFoundException("User not found with this email: " + username);
    }
}

