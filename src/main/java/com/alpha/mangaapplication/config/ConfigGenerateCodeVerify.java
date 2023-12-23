package com.alpha.mangaapplication.config;

import com.alpha.mangaapplication.service.GenerateVerifyCode;
import com.alpha.mangaapplication.service.serviceImp.VerifyCodeManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConfigGenerateCodeVerify {
    @Bean("codeEmail")
    @Primary
    public VerifyCodeManager codeEmail(@Qualifier("codeVerifyEmail")GenerateVerifyCode generateVerifyCode){
        return new VerifyCodeManager(generateVerifyCode);
    }

}
