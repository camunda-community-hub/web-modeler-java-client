# web-modeler-java-client
Java Client for the Web Modeler (based on its OpenAPI spec from https://docs.camunda.io/docs/next/apis-tools/web-modeler-api/)

## How to use

In Spring Boot

Add dependency to Maven pom.xml:

```xml
  <dependency>
    <groupId>org.camunda.community.webmodeler</groupId>
    <artifactId>web-modeler-openapi-springboot</artifactId>
    <version>1.0.1-SNAPSHOT</version>
  </dependency>
```

Add `application.properties`:

```properties
camunda.modeler.client.clientId=WlMOFLRL1sOmZpR9
camunda.modeler.client.clientSecret=1vRRGPfoMbHBcrUZgbaQG0g1j0p~2hTF

camunda.modeler.client.baseUrl=https://modeler.cloud.camunda.io
camunda.modeler.client.oAuthUrl=https://login.cloud.camunda.io/oauth/token
camunda.modeler.client.oAuthAudience=api.cloud.camunda.io
```

Now you can just inject the API:

```java
    @Autowired
    private CamundaWebModelerApi camundaWebModelerApi;

    public void printProjects() {
        System.out.println(
                camundaWebModelerApi.projectsApi().listProjects());
    }
```
