# InfoApi

All URIs are relative to *https://modeler.cloud.camunda.io*

|              Method               |     HTTP request     | Description |
|-----------------------------------|----------------------|-------------|
| [**getInfo**](InfoApi.md#getInfo) | **GET** /api/v1/info |             |

<a name="getInfo"></a>

# **getInfo**

> InfoDto getInfo()

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.InfoApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    InfoApi apiInstance = new InfoApi(defaultClient);
    try {
      InfoDto result = apiInstance.getInfo();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling InfoApi#getInfo");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**InfoDto**](InfoDto.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details

| Status code |      Description      | Response headers |
|-------------|-----------------------|------------------|
| **200**     | OK                    | -                |
| **500**     | Internal Server Error | -                |

