package io.camunda.operate.auth.copy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.community.webmodeler.client.invoker.ApiClient;

public abstract class JwtAuthentication implements AuthInterface {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public ObjectMapper getObjectMapper() {
        return MAPPER;
    }

    public void setToken(ApiClient client, String token)  {
        client.setBearerToken(token);
    }
}
