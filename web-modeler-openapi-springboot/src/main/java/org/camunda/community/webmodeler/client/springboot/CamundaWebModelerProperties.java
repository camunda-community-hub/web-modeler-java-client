package org.camunda.community.webmodeler.client.springboot;

import io.camunda.identity.sdk.IdentityConfiguration.Type;
import java.net.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("camunda.modeler.client")
public record CamundaWebModelerProperties(
    URL baseUrl,
    URL authUrl,
    String audience,
    String clientId,
    String clientSecret,
    Type authType,
    URL identityUrl) {}
