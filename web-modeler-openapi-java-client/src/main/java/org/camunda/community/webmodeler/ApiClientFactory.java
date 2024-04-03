package org.camunda.community.webmodeler;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.camunda.community.webmodeler.client.invoker.ApiClient;

public class ApiClientFactory {
  private static final ApiClientFactory INSTANCE = new ApiClientFactory();

  private ApiClientFactory() {}

  public static ApiClientFactory getInstance() {
    return INSTANCE;
  }

  public ApiClient get(ApiClientConfiguration apiClientConfiguration) {
    CloseableHttpClient httpClient =
        HttpClients.custom()
            .addRequestInterceptorFirst(apiClientConfiguration.authInterceptor())
            .build();
    ApiClient client = new ApiClient(httpClient);
    client.setBasePath(apiClientConfiguration.baseUrl());
    return client;
  }
}
