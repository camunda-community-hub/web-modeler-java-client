# FoldersApi

All URIs are relative to *https://modeler.cloud.camunda.io*

|                     Method                     |             HTTP request              | Description |
|------------------------------------------------|---------------------------------------|-------------|
| [**createFolder**](FoldersApi.md#createFolder) | **POST** /api/v1/folders              |             |
| [**deleteFolder**](FoldersApi.md#deleteFolder) | **DELETE** /api/v1/folders/{folderId} |             |
| [**getFolder**](FoldersApi.md#getFolder)       | **GET** /api/v1/folders/{folderId}    |             |
| [**patchFolder**](FoldersApi.md#patchFolder)   | **PATCH** /api/v1/folders/{folderId}  |             |

<a name="createFolder"></a>

# **createFolder**

> FolderMetadataDto createFolder(createFolderDto)

Creates a new folder.
* When only *parentId* is given, the folder will be created in that folder. The folder can be in any project of the same organization.
* When *projectId* is given and *parentId* is either null or omitted altogether, the folder will be created in the root of the project.
* When *projectId* and *parentId* are both given, they must be consistent - i.e. the parent folder is in the project.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.FoldersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FoldersApi apiInstance = new FoldersApi(defaultClient);
    CreateFolderDto createFolderDto = new CreateFolderDto(); // CreateFolderDto | 
    try {
      FolderMetadataDto result = apiInstance.createFolder(createFolderDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FoldersApi#createFolder");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|        Name         |                   Type                    | Description | Notes |
|---------------------|-------------------------------------------|-------------|-------|
| **createFolderDto** | [**CreateFolderDto**](CreateFolderDto.md) |             |       |

### Return type

[**FolderMetadataDto**](FolderMetadataDto.md)

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

<a name="deleteFolder"></a>

# **deleteFolder**

> deleteFolder(folderId)

This endpoint deletes an empty folder. A folder is considered empty if there are no files in it. Deletion of resources is recursive and cannot be undone.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.FoldersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FoldersApi apiInstance = new FoldersApi(defaultClient);
    UUID folderId = new UUID(); // UUID | 
    try {
      apiInstance.deleteFolder(folderId);
    } catch (ApiException e) {
      System.err.println("Exception when calling FoldersApi#deleteFolder");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|     Name     |      Type       | Description | Notes |
|--------------|-----------------|-------------|-------|
| **folderId** | [**UUID**](.md) |             |       |

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

<a name="getFolder"></a>

# **getFolder**

> FolderDto getFolder(folderId)

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.FoldersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FoldersApi apiInstance = new FoldersApi(defaultClient);
    UUID folderId = new UUID(); // UUID | 
    try {
      FolderDto result = apiInstance.getFolder(folderId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FoldersApi#getFolder");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|     Name     |      Type       | Description | Notes |
|--------------|-----------------|-------------|-------|
| **folderId** | [**UUID**](.md) |             |       |

### Return type

[**FolderDto**](FolderDto.md)

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

<a name="patchFolder"></a>

# **patchFolder**

> FolderMetadataDto patchFolder(folderId, updateFolderDto)

This endpoint updates the name or location of a folder, or both at the same time.

To move a folder, specify *projectId* and/or *parentId*: * When only *parentId* is given, the file will be moved to that       folder. The folder must keep in the same organization.&lt;/p&gt;&lt;/li&gt;   &lt;li&gt;&lt;p&gt;When *projectId* is given and *parentId* is either       null or omitted altogether, the file will be moved to the root of the project.&lt;/p&gt;&lt;/li&gt;   &lt;li&gt;&lt;p&gt;When *projectId* and *parentId* are both given,       they must be consistent - i.e. the new parent folder is in the new project.&lt;/p&gt;&lt;/li&gt; &lt;/ul&gt;

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.FoldersApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    FoldersApi apiInstance = new FoldersApi(defaultClient);
    UUID folderId = new UUID(); // UUID | 
    UpdateFolderDto updateFolderDto = new UpdateFolderDto(); // UpdateFolderDto | 
    try {
      FolderMetadataDto result = apiInstance.patchFolder(folderId, updateFolderDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FoldersApi#patchFolder");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|        Name         |                   Type                    | Description | Notes |
|---------------------|-------------------------------------------|-------------|-------|
| **folderId**        | [**UUID**](.md)                           |             |       |
| **updateFolderDto** | [**UpdateFolderDto**](UpdateFolderDto.md) |             |       |

### Return type

[**FolderMetadataDto**](FolderMetadataDto.md)

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

