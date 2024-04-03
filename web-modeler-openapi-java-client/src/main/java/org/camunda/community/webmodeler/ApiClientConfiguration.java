package org.camunda.community.webmodeler;

public record ApiClientConfiguration(String baseUrl, WebModelerAuthInterceptor authInterceptor) {
  public static final String SAAS_AUTH_URL = "https://login.cloud.camunda.io/oauth/token";
}
