package io.camunda.operate.auth.copy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.community.webmodeler.client.invoker.ApiClient;

import java.util.Base64;

public abstract class JwtAuthentication implements AuthInterface {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Base64.Decoder DECODER = Base64.getUrlDecoder();

    public ObjectMapper getObjectMapper() {
        return MAPPER;
    }

    public int getExpiration(String token) {
        try {
            String[] chunks = token.split("\\.");
            String payload = new String(DECODER.decode(chunks[1]));
            JsonNode jsonPayload = MAPPER.readValue(payload, JsonNode.class);
            JsonNode exp = jsonPayload.get("exp");
            if (exp==null) {
                return 0;
            } else {
                return exp.asInt();
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Token is not readable", e);
        }
    }

    public void setToken(ApiClient client, String token)  {
        client.setBearerToken(token);
        //client.setAuthHeader(new BasicHeader("Authorization", "Bearer " + token));
        client.setBearerToken(token);
        //client.setTokenExpiration(getExpiration(token));
    }
}
