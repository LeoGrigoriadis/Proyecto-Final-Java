package com.mvcCrypto.mvcCrypto.config;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPoint extends BasicAuthenticationEntryPoint{
    
    @Override
    public void commence (HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
        throws IOException, ServerException{
        response.addHeader("WWW-Authenticate", "Basic realm="+ getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
    @Override
    public void afterPropertiesSet(){
        setRealmName("user");
        super.afterPropertiesSet();
    }
}
