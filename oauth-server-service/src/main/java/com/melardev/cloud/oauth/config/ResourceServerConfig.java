package com.melardev.cloud.oauth.config;

import com.melardev.cloud.oauth.security.OAuthAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    // You would not need this class unless you have a controller that requires authentication
    // which in this case I do have, it holds the /api/self endpoint, if I don't have a secured endpoint
    // I could remove this class. In few words: OAuth Server is the guy who issues the tokens
    // Resource Server is the guy who verifies the tokens and has secured endpoints which are accessible only
    // if the token is verified

    @Autowired
    ResourceServerTokenServices tokenServices;

    @Autowired
    private AuthenticationEntryPoint oauthEntryPoint;

    @Autowired
    private OAuthAccessDeniedHandler oauthAccessDeniedHandler;

    @Override
    public void configure(final ResourceServerSecurityConfigurer configurer) {
        configurer.tokenServices(tokenServices);

        configurer.authenticationEntryPoint(oauthEntryPoint);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/self").fullyAuthenticated()
                .anyRequest().permitAll()
                .and().exceptionHandling()
                .authenticationEntryPoint(oauthEntryPoint)
                .accessDeniedHandler(oauthAccessDeniedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.headers().frameOptions().disable(); // otherwise H2 console is not available
        // There are many ways to ways of placing our Filter in a position in the chain
        // You can troubleshoot any error enabling debug(see below), it will print the chain of Filters

    }
}
