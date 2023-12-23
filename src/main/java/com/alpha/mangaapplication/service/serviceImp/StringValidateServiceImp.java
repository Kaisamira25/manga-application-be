package com.alpha.mangaapplication.service.serviceImp;

import com.alpha.mangaapplication.service.StringValidateService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class StringValidateServiceImp implements StringValidateService {
    private final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}$";
    @Override
    public boolean isStringValid(String rawString) {
        Pattern pattern = Pattern.compile(REGEX_PASSWORD);
        // pattern có tác dụng biên dịch đoạn regex cho máy hiểu để tiến hành so sánh với chuỗi cần so sánh
        Matcher matcher = pattern.matcher(rawString);
        // chứa biểu thức chính quy,chuỗi cần so sánh chứ chưa thực hiện so sánh
        return matcher.matches(); // thực hiện so sánh bằng phương thức matches() trả về kiểu boolean
    }
}
