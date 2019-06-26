package com.melardev.cloud.todo.service;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public class AppClientsService implements ClientDetailsService {
    // This is not used at this moment, it is annoying to create an Entity with this Info,
    // I prefer to use JdbcClientDetailsService so sorry, I don't provide an implementation
    // for a custom ClientDetailsService but that should be really easy to do.
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        // resourceIds, scopes, grantTypes and authorities are comma delimited.
        return new BaseClientDetails(clientId, "", "", "password", "");
    }
}
