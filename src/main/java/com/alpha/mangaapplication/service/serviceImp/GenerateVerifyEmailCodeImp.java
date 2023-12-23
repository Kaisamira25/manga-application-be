package com.alpha.mangaapplication.service.serviceImp;

import com.alpha.mangaapplication.service.GenerateVerifyCode;
import com.alpha.mangaapplication.utilities.GetTime;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service("codeVerifyEmail")
@Primary
public class GenerateVerifyEmailCodeImp implements GenerateVerifyCode {
    public static final int EXPIRATION_TIME = 10;
    @Override
    public String generateCode() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Date codeExpiration() {
        return GetTime.getTokenExpirationTime(EXPIRATION_TIME);
    }
}
