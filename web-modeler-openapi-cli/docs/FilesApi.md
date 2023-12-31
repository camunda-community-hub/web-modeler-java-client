# FilesApi

All URIs are relative to *https://modeler.cloud.camunda.io*

|                   Method                   |           HTTP request            | Description |
|--------------------------------------------|-----------------------------------|-------------|
| [**createFile**](FilesApi.md#createFile)   | **POST** /api/v1/files            |             |
| [**deleteFile**](FilesApi.md#deleteFile)   | **DELETE** /api/v1/files/{fileId} |             |
| [**getFile**](FilesApi.md#getFile)         | **GET** /api/v1/files/{fileId}    |             |
| [**patchFile**](FilesApi.md#patchFile)     | **PATCH** /api/v1/files/{fileId}  |             |
| [**searchFiles**](FilesApi.md#searchFiles) | **POST** /api/v1/files/search     |             |

<a name="createFile"></a>

# **createFile**

> FileMetadataDto createFile(createFileDto)

This endpoint creates a file.

To create a file, specify *projectId* and/or *folderId*:
* When only *folderId* is given, the file will be created in that folder. The folder can be in any project of the same organization.
* When *projectId* is given and *folderId* is either null or omitted altogether, the file will be created in the root of the project.
* When *projectId* and*folderId* are both given, they must be consistent - i.e. the folder is in the project.

For connector templates, the following constraints apply:
* The value of *content.$schema* will be replaced with *https://unpkg.com/@camunda/zeebe-element-templates-json-schema/resources/schema.json* and validated against it.
* The value of *name* takes precedence over *content.name*. In case of mismatch, the latter will be adjusted to match the former automatically.
* The value of *content.id* will be replaced with the file *id* generated by Web Modeler.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.FilesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FilesApi apiInstance = new FilesApi(defaultClient);
    CreateFileDto createFileDto = new CreateFileDto(); // CreateFileDto | 
    try {
      FileMetadataDto result = apiInstance.createFile(createFileDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FilesApi#createFile");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|       Name        |                 Type                  | Description | Notes |
|-------------------|---------------------------------------|-------------|-------|
| **createFileDto** | [**CreateFileDto**](CreateFileDto.md) |             |       |

### Return type

[**FileMetadataDto**](FileMetadataDto.md)

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

<a name="deleteFile"></a>

# **deleteFile**

> deleteFile(fileId)

Deletes a file.

**Note:** Deleting a file will also delete other resources attached to the file (comments, call activity/business rule task links, milestones and shares) which might have side-effects.  Deletion of resources is recursive and cannot be undone.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.FilesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FilesApi apiInstance = new FilesApi(defaultClient);
    UUID fileId = new UUID(); // UUID | 
    try {
      apiInstance.deleteFile(fileId);
    } catch (ApiException e) {
      System.err.println("Exception when calling FilesApi#deleteFile");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|    Name    |      Type       | Description | Notes |
|------------|-----------------|-------------|-------|
| **fileId** | [**UUID**](.md) |             |       |

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

<a name="getFile"></a>

# **getFile**

> FileDto getFile(fileId)

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.FilesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FilesApi apiInstance = new FilesApi(defaultClient);
    UUID fileId = new UUID(); // UUID | 
    try {
      FileDto result = apiInstance.getFile(fileId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FilesApi#getFile");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|    Name    |      Type       | Description | Notes |
|------------|-----------------|-------------|-------|
| **fileId** | [**UUID**](.md) |             |       |

### Return type

[**FileDto**](FileDto.md)

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

<a name="patchFile"></a>

# **patchFile**

> FileMetadataDto patchFile(fileId, updateFileDto)

This endpoint updates the content, name, or location of a file, or all at the same time.

To move a file, specify *projectId* and/or *folderId*:
* When only *folderId* is given, the file will be moved to that folder. The folder can be in another project of the same organization.
* When *projectId* is given and *folderId* is either null or omitted altogether, the file will be moved to the root of the project.
* When *projectId* and *folderId* are both given, they must be consistent - i.e. the new parent folder is in the new project.

The field *revision* holds the current revision of the file. This is used for detecting and preventing concurrent modifications.
For connector templates, the following constraints apply:
* The value of *content.$schema* is not updatable.
* The value of *content.name* can only be changed via *name*.
* The value of *content.id* is not updatable.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.FilesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FilesApi apiInstance = new FilesApi(defaultClient);
    UUID fileId = new UUID(); // UUID | 
    UpdateFileDto updateFileDto = new UpdateFileDto(); // UpdateFileDto | 
    try {
      FileMetadataDto result = apiInstance.patchFile(fileId, updateFileDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FilesApi#patchFile");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|       Name        |                 Type                  | Description | Notes |
|-------------------|---------------------------------------|-------------|-------|
| **fileId**        | [**UUID**](.md)                       |             |       |
| **updateFileDto** | [**UpdateFileDto**](UpdateFileDto.md) |             |       |

### Return type

[**FileMetadataDto**](FileMetadataDto.md)

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
| **403**     | Forbidden             | -                |
| **404**     | Not Found             | -                |
| **409**     | Conflict              | -                |
| **500**     | Internal Server Error | -                |

<a name="searchFiles"></a>

# **searchFiles**

> PubSearchResultDtoFileMetadataDto searchFiles(pubSearchDtoFileMetadataDto)

Searches for files.
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
import org.camunda.community.webmodeler.client.api.FilesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FilesApi apiInstance = new FilesApi(defaultClient);
    PubSearchDtoFileMetadataDto pubSearchDtoFileMetadataDto = new PubSearchDtoFileMetadataDto(); // PubSearchDtoFileMetadataDto | 
    try {
      PubSearchResultDtoFileMetadataDto result = apiInstance.searchFiles(pubSearchDtoFileMetadataDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FilesApi#searchFiles");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|              Name               |                               Type                                | Description | Notes |
|---------------------------------|-------------------------------------------------------------------|-------------|-------|
| **pubSearchDtoFileMetadataDto** | [**PubSearchDtoFileMetadataDto**](PubSearchDtoFileMetadataDto.md) |             |       |

### Return type

[**PubSearchResultDtoFileMetadataDto**](PubSearchResultDtoFileMetadataDto.md)

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

