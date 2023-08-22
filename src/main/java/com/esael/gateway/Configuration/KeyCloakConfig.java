package com.esael.gateway.Configuration;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
public class KeyCloakConfig {

    @Autowired
    Keycloak keycloak;

    @Value("${keycloak.auth-server-url}")
    private String url;
    @Value("${realm}")
    private String realm;
    @Value("${keycloak.realm}")
    private String clientId;
    @Value("{username}")
    private String username;
    @Value("${passowrd}")
    private String password;
    @Bean
    public Keycloak keycloak(){
        return KeycloakBuilder.builder()
                .serverUrl(url)
                .realm(realm)
                .clientId(clientId)
                .username(username)
                .password(password)
                .build();
    }
}
