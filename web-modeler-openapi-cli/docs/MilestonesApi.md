# MilestonesApi

All URIs are relative to *https://modeler.cloud.camunda.io*

|                           Method                            |                            HTTP request                            | Description |
|-------------------------------------------------------------|--------------------------------------------------------------------|-------------|
| [**compareMilestones**](MilestonesApi.md#compareMilestones) | **GET** /api/v1/milestones/compare/{milestone1Id}...{milestone2Id} |             |
| [**createMilestone**](MilestonesApi.md#createMilestone)     | **POST** /api/v1/milestones                                        |             |
| [**deleteMilestone**](MilestonesApi.md#deleteMilestone)     | **DELETE** /api/v1/milestones/{milestoneId}                        |             |
| [**getMilestone**](MilestonesApi.md#getMilestone)           | **GET** /api/v1/milestones/{milestoneId}                           |             |
| [**searchMilestones**](MilestonesApi.md#searchMilestones)   | **POST** /api/v1/milestones/search                                 |             |

<a name="compareMilestones"></a>

# **compareMilestones**

> MilestoneComparisonDto compareMilestones(milestone1Id, milestone2Id)

Returns a link to a visual comparison between two milestones where the milestone referenced by `milestone1Id` acts as a baseline to compare the milestone referenced by `milestone2Id` against.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.MilestonesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MilestonesApi apiInstance = new MilestonesApi(defaultClient);
    UUID milestone1Id = new UUID(); // UUID | 
    UUID milestone2Id = new UUID(); // UUID | 
    try {
      MilestoneComparisonDto result = apiInstance.compareMilestones(milestone1Id, milestone2Id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MilestonesApi#compareMilestones");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|       Name       |      Type       | Description | Notes |
|------------------|-----------------|-------------|-------|
| **milestone1Id** | [**UUID**](.md) |             |       |
| **milestone2Id** | [**UUID**](.md) |             |       |

### Return type

[**MilestoneComparisonDto**](MilestoneComparisonDto.md)

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

<a name="createMilestone"></a>

# **createMilestone**

> MilestoneMetadataDto createMilestone(createMilestoneDto)

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.MilestonesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MilestonesApi apiInstance = new MilestonesApi(defaultClient);
    CreateMilestoneDto createMilestoneDto = new CreateMilestoneDto(); // CreateMilestoneDto | 
    try {
      MilestoneMetadataDto result = apiInstance.createMilestone(createMilestoneDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MilestonesApi#createMilestone");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|          Name          |                      Type                       | Description | Notes |
|------------------------|-------------------------------------------------|-------------|-------|
| **createMilestoneDto** | [**CreateMilestoneDto**](CreateMilestoneDto.md) |             |       |

### Return type

[**MilestoneMetadataDto**](MilestoneMetadataDto.md)

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

<a name="deleteMilestone"></a>

# **deleteMilestone**

> deleteMilestone(milestoneId)

Deletion of resources is recursive and cannot be undone.

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.MilestonesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MilestonesApi apiInstance = new MilestonesApi(defaultClient);
    UUID milestoneId = new UUID(); // UUID | 
    try {
      apiInstance.deleteMilestone(milestoneId);
    } catch (ApiException e) {
      System.err.println("Exception when calling MilestonesApi#deleteMilestone");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|      Name       |      Type       | Description | Notes |
|-----------------|-----------------|-------------|-------|
| **milestoneId** | [**UUID**](.md) |             |       |

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

<a name="getMilestone"></a>

# **getMilestone**

> MilestoneDto getMilestone(milestoneId)

### Example

```java
// Import classes:
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.camunda.community.webmodeler.client.invoker.ApiException;
import org.camunda.community.webmodeler.client.invoker.Configuration;
import org.camunda.community.webmodeler.client.invoker.auth.*;
import org.camunda.community.webmodeler.client.invoker.models.*;
import org.camunda.community.webmodeler.client.api.MilestonesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MilestonesApi apiInstance = new MilestonesApi(defaultClient);
    UUID milestoneId = new UUID(); // UUID | 
    try {
      MilestoneDto result = apiInstance.getMilestone(milestoneId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MilestonesApi#getMilestone");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|      Name       |      Type       | Description | Notes |
|-----------------|-----------------|-------------|-------|
| **milestoneId** | [**UUID**](.md) |             |       |

### Return type

[**MilestoneDto**](MilestoneDto.md)

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

<a name="searchMilestones"></a>

# **searchMilestones**

> PubSearchResultDtoMilestoneMetadataDto searchMilestones(pubSearchDtoMilestoneMetadataDto)

Searches for milestones.
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
import org.camunda.community.webmodeler.client.api.MilestonesApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://modeler.cloud.camunda.io");
    
    // Configure HTTP bearer authorization: Bearer
    HttpBearerAuth Bearer = (HttpBearerAuth) defaultClient.getAuthentication("Bearer");
    Bearer.setBearerToken("BEARER TOKEN");

    MilestonesApi apiInstance = new MilestonesApi(defaultClient);
    PubSearchDtoMilestoneMetadataDto pubSearchDtoMilestoneMetadataDto = new PubSearchDtoMilestoneMetadataDto(); // PubSearchDtoMilestoneMetadataDto | 
    try {
      PubSearchResultDtoMilestoneMetadataDto result = apiInstance.searchMilestones(pubSearchDtoMilestoneMetadataDto);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling MilestonesApi#searchMilestones");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

|                 Name                 |                                    Type                                     | Description | Notes |
|--------------------------------------|-----------------------------------------------------------------------------|-------------|-------|
| **pubSearchDtoMilestoneMetadataDto** | [**PubSearchDtoMilestoneMetadataDto**](PubSearchDtoMilestoneMetadataDto.md) |             |       |

### Return type

[**PubSearchResultDtoMilestoneMetadataDto**](PubSearchResultDtoMilestoneMetadataDto.md)

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

