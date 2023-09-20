package org.camunda.community.webmodeler.client.springboot;

import io.camunda.operate.auth.copy.AuthInterface;
import io.camunda.operate.auth.copy.SaasAuthentication;
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamundaWebModelerClientStarter {

    @Value( "${camunda.modeler.client.baseUrl:https://modeler.cloud.camunda.io}" )
    private String basePath;
    @Value( "${camunda.modeler.client.oAuthUrl:https://login.cloud.camunda.io/oauth/token/}" )
    private String oAuthUrl;

    @Value( "${camunda.modeler.client.oAuthAudience:api.cloud.camunda.io}" )
    private String oAuthAudience;

    @Value( "${camunda.modeler.client.clientId}" )
    private String clientId;
    @Value( "${camunda.modeler.client.clientSecret}" )
    private String clientSecret;

    @Bean
    public CamundaWebModelerApi createCamundaWebModelerApi(ApiClient client) {
        return new CamundaWebModelerApi(client);
    }

    @Bean
    public ApiClient createApiClient() {
        ApiClient client = new ApiClient();
        client.setBasePath(basePath);

        AuthInterface authInterface = new SaasAuthentication(oAuthUrl, oAuthAudience, clientId, clientSecret);
        authInterface.authenticate(client);
        // TODO: Timeout handling?

        return client;
    }

}
