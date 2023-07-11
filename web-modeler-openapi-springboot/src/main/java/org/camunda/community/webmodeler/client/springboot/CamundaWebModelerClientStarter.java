package org.camunda.community.webmodeler.client.springboot;

import io.camunda.operate.auth.copy.AuthInterface;
import io.camunda.operate.auth.copy.SaasAuthentication;
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaWebModelerClientStarter {

    @Value( "${camunda.bpm.client.baseUrl:https://modeler.cloud.camunda.io/api/beta/}" )
    private String basePath;
    @Value( "${camunda.bpm.client.authUrl:https://login.cloud.camunda.io/oauth/token/}" )
    private String oauthUrl;

    @Value( "${camunda.bpm.client.oauthAudience:api.cloud.camunda.io}" )
    private String oauthAudience;

    @Value( "${camunda.modeler.client.clientId}" )
    private String clientId;
    @Value( "${camunda.modeler.client.clientSecret}" )
    private String clientSecret;

    private AuthInterface authInterface;

    @Bean
    public ApiClient createApiClient() {
        ApiClient client = new ApiClient();
        //
        // client.setBasePath(basePath);

        authInterface = new SaasAuthentication(oauthUrl, oauthAudience, clientId, clientSecret);
        authInterface.authenticate(client);
        // TODO: Timeout handling?

        return client;
    }

}
