package com.alpha.mangaapplication.filter;

import com.alpha.mangaapplication.model.User;
import com.alpha.mangaapplication.repository.UserRepository;
import com.alpha.mangaapplication.utilities.CustomUser.CustomUserDetailsService;
import com.alpha.mangaapplication.utilities.JwtGenerate.GenerateJwtToken;
import com.alpha.mangaapplication.utilities.JwtGenerate.ValidateToken;
import com.alpha.mangaapplication.utilities.UserInfo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private GenerateJwtToken generateJwtToken;

    @Autowired
    private ValidateToken validateToken;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private UserInfo userInfo;

    @Autowired
    private UserRepository userRepository;

    public static String getAccessTokenFromRequestAuthorization(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }
    public static String getRefreshTokenFromRequestCookie(HttpServletRequest request){
        String token = request.getHeader("refreshToken");
        if (token != null){
            return token;
        }
        return null;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("-----> JwtAuthenticationFilter: doFilterInternal start");
        try {
            String jwt = getAccessTokenFromRequestAuthorization(request);

            if (StringUtils.hasText(jwt) && validateToken.validateToken(jwt)){
                Integer userId = userInfo.getUserId(jwt);
                log.info("-----> JwtAuthenticationFilter: doFilter get the userId");
                Optional<User> user = userRepository.findById(userId);
                if (user != null){
                    UserDetails userDetails = customUserDetailsService.loadUserByUsername(user.get().getEmail());

                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }catch (Exception e){
            log.error("-----> JwtAuthenticationFilter: Fail");
        }
        filterChain.doFilter(request,response);
    }
}
