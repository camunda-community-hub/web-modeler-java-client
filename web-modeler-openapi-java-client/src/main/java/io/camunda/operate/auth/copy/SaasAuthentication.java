package io.camunda.operate.auth.copy;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.camunda.community.webmodeler.client.invoker.ApiClient;

import java.io.IOException;

public class SaasAuthentication extends JwtAuthentication {

    private String clientId;
    private String clientSecret;

    private String oauthAudience;
    private String oauthUrl;

    public SaasAuthentication(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;

        this.oauthUrl = "https://login.cloud.camunda.io/oauth/token";
        this.oauthAudience = "api.cloud.camunda.io";
    }

    public SaasAuthentication(String oauthUrl, String oauthAudience, String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.oauthUrl = oauthUrl;
        this.oauthAudience = oauthAudience;
    }

    public static CloseableHttpResponse execute(CloseableHttpClient httpClient, ClassicHttpRequest request) throws IOException {
        CloseableHttpResponse response = httpClient.execute(request);
        if (response.getCode()>399) {
            throw new RuntimeException("Authentication error : "+response.getCode()+" "+response.getReasonPhrase());
        }
        return response;
    }

    @Override
    public void authenticate(ApiClient client) {

        HttpPost httpPost = new HttpPost(oauthUrl);
        httpPost.addHeader("Content-Type", "application/json");

        String data = "{\"grant_type\":\"client_credentials\", \"audience\":\"" + oauthAudience + "\", \"client_id\": \""
                + clientId + "\", \"client_secret\":\"" + clientSecret + "\"}";
        httpPost.setEntity(new StringEntity(data));

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            try (CloseableHttpResponse response = execute(httpClient, httpPost)) {
                JsonNode responseBody = getObjectMapper().readTree(response.getEntity().getContent());
                String token = responseBody.get("access_token").asText();

                setToken(client, token);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
