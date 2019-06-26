package com.melardev.cloud.todo.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(

            OAuth2AccessToken accessToken,
            OAuth2Authentication authentication) {

        Map<String, Object> info = new LinkedHashMap<String, Object>(accessToken.getAdditionalInformation());
        info.put("roles", authentication.getAuthorities());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;
    }
}
