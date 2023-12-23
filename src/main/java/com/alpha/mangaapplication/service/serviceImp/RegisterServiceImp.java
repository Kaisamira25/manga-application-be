package com.alpha.mangaapplication.service.serviceImp;

import com.alpha.mangaapplication.dto.request.RegisterDTO;
import com.alpha.mangaapplication.model.User;
import com.alpha.mangaapplication.service.CreateAndUpdateService;
import com.alpha.mangaapplication.service.RegisterService;
import com.alpha.mangaapplication.service.StringValidateService;
import com.alpha.mangaapplication.service.UserService;
import com.alpha.mangaapplication.utilities.GetTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegisterServiceImp implements RegisterService {
    private final UserService userService;

    private final StringValidateService validateString;

    private final PasswordEncoder encoder;

    private final CreateAndUpdateService<Integer,User> createUser;

    @Qualifier("codeEmail")
    private final VerifyCodeManager verifyCodeManager;
    @Override
    public Integer register(RegisterDTO registerDTO) {
        if (userService.findByEmail(registerDTO.email()) == null){
            if (validateString.isStringValid(registerDTO.password()) == false){
                return 0;
            }
            User user = new User();
            user.setEmail(registerDTO.email());
            user.setFullName(registerDTO.fullName());
            user.setPassword(encoder.encode(registerDTO.password()));
            user.setCreatedAt(GetTime.getCurrentTime());
            user.setVerifyEmailCode(verifyCodeManager.generateCode());
            user.setVerifyEmailCodeExpiration(verifyCodeManager.codeExpiration());
            user.setRefreshPasswordCode(null);
            user.setRefreshPasswordCodeExpiration(null);
            createUser.create(user);
            log.info("-----> RegisterServiceImp: Create User successful");
            return 1;
        }else{
            return 2;
        }
    }
}
