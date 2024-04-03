package org.camunda.community.webmodeler.client.springboot;

import io.camunda.identity.sdk.IdentityConfiguration.Type;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URL;

@ConfigurationProperties("camunda.modeler.client")
public record CamundaWebModelerProperties(
    URL baseUrl,
    URL authUrl,
    String audience,
    String clientId,
    String clientSecret,
    Type authType,
    URL identityUrl) {}
