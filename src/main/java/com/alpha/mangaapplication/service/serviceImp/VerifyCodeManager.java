package com.alpha.mangaapplication.service.serviceImp;

import com.alpha.mangaapplication.service.GenerateVerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VerifyCodeManager {
    private final GenerateVerifyCode generateVerifyCode;
    @Autowired
    public VerifyCodeManager(GenerateVerifyCode generateVerifyCode){
        this.generateVerifyCode = generateVerifyCode;
    }
    public String generateCode(){
        return this.generateVerifyCode.generateCode();
    }
    public Date codeExpiration(){
        return this.generateVerifyCode.codeExpiration();
    }
}
