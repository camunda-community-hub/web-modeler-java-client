# web-modeler-java-client
Java Client for the Web Modeler (based on its OpenAPI spec from https://docs.camunda.io/docs/next/apis-tools/web-modeler-api/)

## How to use

In Spring Boot

Add dependency to Maven `pom.xml`:

```xml
  <dependency>
    <groupId>org.camunda.community.webmodeler</groupId>
    <artifactId>web-modeler-openapi-springboot</artifactId>
    <version>1.0.0</version>
  </dependency>
```

Add `application.yaml`:

```yaml
camunda:
  modeler:
    client:
      base-url: https://modeler.cloud.camunda.io
      auth-url: https://login.cloud.camunda.io/oauth/token
      audience: api.cloud.camunda.io
      auth-type: KEYCLOAK
      identity-url: http://localhost:8084
      client-id: <YOUR_CLIENDID>
      client-secret: <YOUR_CLIENTSECRET>
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
