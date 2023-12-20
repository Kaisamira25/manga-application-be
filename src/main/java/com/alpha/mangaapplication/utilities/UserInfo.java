package com.alpha.mangaapplication.utilities;

import com.alpha.mangaapplication.utilities.KeyReader.KeyReader;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserInfo {
    public Integer getUserId(String token){
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(KeyReader.PUBLIC_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            log.info("-----> UserInfo: getUserId get the userid form token: {}",claims.get("userId"));
            return claims.get("userId",Integer.class);
        }catch (Exception e){
            log.error("-----> UserInfo: getUserId got the error: {}",e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
