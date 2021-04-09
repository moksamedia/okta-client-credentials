package com.example.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.*;
import org.springframework.security.oauth2.client.registration.*;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OAuthClientConfiguration {

    @Bean
    ReactiveClientRegistrationRepository clientRegistrations(
            @Value("${spring.security.oauth2.client.provider.okta.token-uri}") String token_uri,
            @Value("${spring.security.oauth2.client.registration.okta.client-id}") String client_id,
            @Value("${spring.security.oauth2.client.registration.okta.client-secret}") String client_secret,
            @Value("${spring.security.oauth2.client.registration.okta.scope}") String scope,
            @Value("${spring.security.oauth2.client.registration.okta.authorization-grant-type}") String authorizationGrantType

    ) {
        ClientRegistration registration = ClientRegistration
                .withRegistrationId("okta")
                .tokenUri(token_uri)
                .clientId(client_id)
                .clientSecret(client_secret)
                .scope(scope)
                .authorizationGrantType(new AuthorizationGrantType(authorizationGrantType))
                .build();
        return new InMemoryReactiveClientRegistrationRepository(registration);
    }

    @Bean
    WebClient webClient(ReactiveClientRegistrationRepository clientRegistrations) {
        InMemoryReactiveOAuth2AuthorizedClientService clientService = new InMemoryReactiveOAuth2AuthorizedClientService(clientRegistrations);
        AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager authorizedClientManager = new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(clientRegistrations, clientService);
        ServerOAuth2AuthorizedClientExchangeFilterFunction oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(authorizedClientManager);
        oauth.setDefaultClientRegistrationId("okta");
        return WebClient.builder()
                .filter(oauth)
                .build();

    }

}