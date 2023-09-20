package io.camunda.operate.auth.copy;

import org.camunda.community.webmodeler.client.invoker.ApiClient;

public interface AuthInterface {
    void authenticate(ApiClient client);
}
