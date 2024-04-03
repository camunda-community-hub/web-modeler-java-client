package org.camunda.community.webmodeler;

import io.camunda.common.auth.Authentication;
import io.camunda.common.auth.Product;
import java.util.Map.Entry;
import org.apache.hc.core5.http.EntityDetails;
import org.apache.hc.core5.http.HttpRequest;
import org.apache.hc.core5.http.HttpRequestInterceptor;
import org.apache.hc.core5.http.protocol.HttpContext;

public class WebModelerAuthInterceptor implements HttpRequestInterceptor {
  private final Authentication authentication;

  public WebModelerAuthInterceptor(Authentication authentication) {
    this.authentication = authentication;
  }

  @Override
  public void process(
      HttpRequest httpRequest, EntityDetails entityDetails, HttpContext httpContext) {
    Entry<String, String> tokenHeader = authentication.getTokenHeader(Product.WEB_MODELER);
    httpRequest.setHeader(tokenHeader.getKey(), tokenHeader.getValue());
  }
}
