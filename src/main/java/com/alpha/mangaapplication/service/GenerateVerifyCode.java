package com.alpha.mangaapplication.service;

import java.util.Date;

public interface GenerateVerifyCode {
    String generateCode();

    Date codeExpiration();
}
