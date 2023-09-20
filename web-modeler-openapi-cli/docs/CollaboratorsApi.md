# CollaboratorsApi

All URIs are relative to *https://modeler.cloud.camunda.io*

|                               Method                               |                         HTTP request                          | Description |
|--------------------------------------------------------------------|---------------------------------------------------------------|-------------|
| [**deleteCollaborator**](CollaboratorsApi.md#deleteCollaborator)   | **DELETE** /api/v1/projects/{projectId}/collaborators/{email} |             |
| [**modifyCollaborator**](CollaboratorsApi.md#modifyCollaborator)   | **PUT** /api/v1/collaborators                                 |             |
| [**searchCollaborators**](CollaboratorsApi.md#searchCollaborators) | **POST** /api/v1/collaborators/search                         |             |

<a name="deleteCollaborator"></a>

# **deleteCollaborator**

> deleteCollaborator(projectId, email)

Deletion of resources is recursive and cannot be undone.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.CollaboratorsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    CollaboratorsApi apiInstance = new CollaboratorsApi(defaultClient);
    UUID projectId = new UUID(); // UUID | 
    String email = "email_example"; // String | 
    try {
      apiInstance.deleteCollaborator(projectId, email);
    } catch (ApiException e) {
      System.err.println("Exception when calling CollaboratorsApi#deleteCollaborator");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|     Name      |      Type       | Description | Notes |
|---------------|-----------------|-------------|-------|
| **projectId** | [**UUID**](.md) |             |       |
| **email**     | **String**      |             |       |

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details

| Status code |      Description      | Response headers |
|-------------|-----------------------|------------------|
| **204**     | No Content            | -                |
| **404**     | Not Found             | -                |
| **500**     | Internal Server Error | -                |

<a name="modifyCollaborator"></a>

# **modifyCollaborator**

> modifyCollaborator(createCollaboratorDto)

Adds a new collaborator to a project or modifies the permission level of an existing collaborator.

**Note:** Only users that are part of the authorized organization (see `GET /api/v1/info`) *and* logged in to Web Modeler at least once can be added to a project.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.CollaboratorsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    CollaboratorsApi apiInstance = new CollaboratorsApi(defaultClient);
    CreateCollaboratorDto createCollaboratorDto = new CreateCollaboratorDto(); // CreateCollaboratorDto | 
    try {
      apiInstance.modifyCollaborator(createCollaboratorDto);
    } catch (ApiException e) {
      System.err.println("Exception when calling CollaboratorsApi#modifyCollaborator");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|           Name            |                         Type                          | Description | Notes |
|---------------------------|-------------------------------------------------------|-------------|-------|
| **createCollaboratorDto** | [**CreateCollaboratorDto**](CreateCollaboratorDto.md) |             |       |

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details

| Status code |      Description      | Response headers |
|-------------|-----------------------|------------------|
| **204**     | No Content            | -                |
| **400**     | Bad Request           | -                |
| **404**     | Not Found             | -                |
| **500**     | Internal Server Error | -                |

<a name="searchCollaborators"></a>

# **searchCollaborators**

> PubSearchResultDtoProjectCollaboratorDto searchCollaborators(pubSearchDtoProjectCollaboratorDto)

Searches for collaborators.
* *filter* specifies which fields should match. Only items that match the given fields will be returned.
* *sort* specifies by which fields and direction (`ASC`/`DESC`) the result should be sorted.
* *page* specifies the page number to return.
* *size* specifies the number of items per page. The default value is 10.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.CollaboratorsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    CollaboratorsApi apiInstance = new CollaboratorsApi(defaultClient);
    PubSearchDtoProjectCollaboratorDto pubSearchDtoProjectCollaboratorDto = new PubSearchDtoProjectCollaboratorDto(); // PubSearchDtoProjectCollaboratorDto | 
    try {
      PubSearchResultDtoProjectCollaboratorDto result = apiInstance.searchCollaborators(pubSearchDtoProjectCollaboratorDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CollaboratorsApi#searchCollaborators");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|                  Name                  |                                      Type                                       | Description | Notes |
|----------------------------------------|---------------------------------------------------------------------------------|-------------|-------|
| **pubSearchDtoProjectCollaboratorDto** | [**PubSearchDtoProjectCollaboratorDto**](PubSearchDtoProjectCollaboratorDto.md) |             |       |

### Return type

[**PubSearchResultDtoProjectCollaboratorDto**](PubSearchResultDtoProjectCollaboratorDto.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details

| Status code |      Description      | Response headers |
|-------------|-----------------------|------------------|
| **200**     | OK                    | -                |
| **400**     | Bad Request           | -                |
| **404**     | Not Found             | -                |
| **500**     | Internal Server Error | -                |

