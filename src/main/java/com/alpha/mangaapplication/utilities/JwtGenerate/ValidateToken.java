package com.alpha.mangaapplication.utilities.JwtGenerate;

import com.alpha.mangaapplication.utilities.KeyReader.KeyReader;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidateToken {
    public boolean validateToken(String token){
        try{
            Jwts.parser()
                    .setSigningKey(KeyReader.PUBLIC_KEY)
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            log.error("-----> ValidateToken: validateToken got the error: {}",e.getMessage());
        }
        return false;
    }
}
