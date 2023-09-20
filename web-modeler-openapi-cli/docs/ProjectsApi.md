# ProjectsApi

All URIs are relative to *https://modeler.cloud.camunda.io*

|                       Method                        |              HTTP request               | Description |
|-----------------------------------------------------|-----------------------------------------|-------------|
| [**createProject**](ProjectsApi.md#createProject)   | **POST** /api/v1/projects               |             |
| [**deleteProject**](ProjectsApi.md#deleteProject)   | **DELETE** /api/v1/projects/{projectId} |             |
| [**getProject**](ProjectsApi.md#getProject)         | **GET** /api/v1/projects/{projectId}    |             |
| [**searchProjects**](ProjectsApi.md#searchProjects) | **POST** /api/v1/projects/search        |             |
| [**updateProject**](ProjectsApi.md#updateProject)   | **PATCH** /api/v1/projects/{projectId}  |             |

<a name="createProject"></a>

# **createProject**

> ProjectMetadataDto createProject(createProjectDto)

Creates a new project. This project will be created without any collaborators, so it will not be visible in the UI by default. To assign collaborators, use `PUT /api/v1/collaborators`.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.ProjectsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    ProjectsApi apiInstance = new ProjectsApi(defaultClient);
    CreateProjectDto createProjectDto = new CreateProjectDto(); // CreateProjectDto | 
    try {
      ProjectMetadataDto result = apiInstance.createProject(createProjectDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProjectsApi#createProject");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|         Name         |                    Type                     | Description | Notes |
|----------------------|---------------------------------------------|-------------|-------|
| **createProjectDto** | [**CreateProjectDto**](CreateProjectDto.md) |             |       |

### Return type

[**ProjectMetadataDto**](ProjectMetadataDto.md)

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

<a name="deleteProject"></a>

# **deleteProject**

> deleteProject(projectId)

This endpoint deletes an empty project. A project is considered empty if there are no files in it. Deletion of resources is recursive and cannot be undone.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.ProjectsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    ProjectsApi apiInstance = new ProjectsApi(defaultClient);
    UUID projectId = new UUID(); // UUID | 
    try {
      apiInstance.deleteProject(projectId);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProjectsApi#deleteProject");
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

<a name="getProject"></a>

# **getProject**

> ProjectDto getProject(projectId)

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.ProjectsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    ProjectsApi apiInstance = new ProjectsApi(defaultClient);
    UUID projectId = new UUID(); // UUID | 
    try {
      ProjectDto result = apiInstance.getProject(projectId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProjectsApi#getProject");
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

### Return type

[**ProjectDto**](ProjectDto.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details

| Status code |      Description      | Response headers |
|-------------|-----------------------|------------------|
| **200**     | OK                    | -                |
| **404**     | Not Found             | -                |
| **500**     | Internal Server Error | -                |

<a name="searchProjects"></a>

# **searchProjects**

> PubSearchResultDtoProjectMetadataDto searchProjects(pubSearchDtoProjectMetadataDto)

Searches for projects.
* *filter* specifies which fields should match. Only items that match the given fields will be returned.
**Note:** Date fields need to be specified in a format compatible with `java.time.ZonedDateTime`; for example `2023-09-20T11:31:20.206801604Z`.
You can use suffixes to match date ranges:

| Modifier |   Description   |
|----------|-----------------|
| \|\|/y   | Within a year   |
| \|\|/M   | Within a month  |
| \|\|/w   | Within a week   |
| \|\|/d   | Within a day    |
| \|\|/h   | Within an hour  |
| \|\|/m   | Within a minute |
| \|\|/s   | Within a second |

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
import org.camunda.community.webmodeler.client.api.ProjectsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    ProjectsApi apiInstance = new ProjectsApi(defaultClient);
    PubSearchDtoProjectMetadataDto pubSearchDtoProjectMetadataDto = new PubSearchDtoProjectMetadataDto(); // PubSearchDtoProjectMetadataDto | 
    try {
      PubSearchResultDtoProjectMetadataDto result = apiInstance.searchProjects(pubSearchDtoProjectMetadataDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProjectsApi#searchProjects");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|                Name                |                                  Type                                   | Description | Notes |
|------------------------------------|-------------------------------------------------------------------------|-------------|-------|
| **pubSearchDtoProjectMetadataDto** | [**PubSearchDtoProjectMetadataDto**](PubSearchDtoProjectMetadataDto.md) |             |       |

### Return type

[**PubSearchResultDtoProjectMetadataDto**](PubSearchResultDtoProjectMetadataDto.md)

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

<a name="updateProject"></a>

# **updateProject**

> ProjectMetadataDto updateProject(projectId, updateProjectDto)

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.ProjectsApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    ProjectsApi apiInstance = new ProjectsApi(defaultClient);
    UUID projectId = new UUID(); // UUID | 
    UpdateProjectDto updateProjectDto = new UpdateProjectDto(); // UpdateProjectDto | 
    try {
      ProjectMetadataDto result = apiInstance.updateProject(projectId, updateProjectDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling ProjectsApi#updateProject");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|         Name         |                    Type                     | Description | Notes |
|----------------------|---------------------------------------------|-------------|-------|
| **projectId**        | [**UUID**](.md)                             |             |       |
| **updateProjectDto** | [**UpdateProjectDto**](UpdateProjectDto.md) |             |       |

### Return type

[**ProjectMetadataDto**](ProjectMetadataDto.md)

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

