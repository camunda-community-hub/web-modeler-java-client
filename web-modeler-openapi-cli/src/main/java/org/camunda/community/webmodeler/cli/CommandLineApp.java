package org.camunda.community.webmodeler.cli;

import static org.camunda.community.webmodeler.ApiClientConfiguration.*;

import io.camunda.common.auth.Authentication;
import io.camunda.common.auth.JwtConfig;
import io.camunda.common.auth.JwtCredential;
import io.camunda.common.auth.Product;
import io.camunda.common.auth.SaaSAuthentication;
import io.camunda.common.auth.SelfManagedAuthentication;
import io.camunda.common.auth.identity.IdentityConfig;
import io.camunda.common.auth.identity.IdentityContainer;
import io.camunda.common.json.JsonMapper;
import io.camunda.common.json.SdkObjectMapper;
import io.camunda.identity.sdk.Identity;
import io.camunda.identity.sdk.IdentityConfiguration;
import io.camunda.identity.sdk.IdentityConfiguration.Type;
import org.camunda.community.webmodeler.ApiClientConfiguration;
import org.camunda.community.webmodeler.ApiClientFactory;
import org.camunda.community.webmodeler.WebModelerAuthInterceptor;
import org.camunda.community.webmodeler.client.api.*;
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(description = "Web Modeler CLI", mixinStandardHelpOptions = true)
public class CommandLineApp {

  public static final int MAX_PAGE_SIZE = 50;

  @Option(
      names = {"--token", "-t"},
      description = "JWT token",
      scope = CommandLine.ScopeType.INHERIT)
  @Deprecated
  String token;

  @Option(
      names = {"--basePath", "-b", "--baseUrl"},
      description = "base url of API (default to Camunda Modeler Saas url)",
      scope = CommandLine.ScopeType.INHERIT,
      defaultValue = "${CAMUNDA_MODELER_CLIENT_BASEURL:-https://modeler.cloud.camunda.io}")
  String baseUrl;

  @Option(
      names = {"--authUrl"},
      description = "auth url of API (default to Camunda Saas auth url)",
      scope = CommandLine.ScopeType.INHERIT,
      defaultValue =
          "${CAMUNDA_MODELER_CLIENT_AUTHURL:-https://login.cloud.camunda.io/oauth/token}")
  String authUrl;

  @Option(
      names = {"--audience"},
      description = "audience of API (default to Camunda Saas audience)",
      scope = CommandLine.ScopeType.INHERIT,
      defaultValue = "${CAMUNDA_MODELER_CLIENT_AUDIENCE:-api.cloud.camunda.io}")
  String audience;

  @Option(
      names = {"--clientId"},
      description = "client id",
      scope = CommandLine.ScopeType.INHERIT,
      defaultValue = "${CAMUNDA_MODELER_CLIENT_CLIENTID}")
  String clientId;

  @Option(
      names = {"--clientSecret"},
      description = "client secret",
      scope = CommandLine.ScopeType.INHERIT,
      defaultValue = "${CAMUNDA_MODELER_CLIENT_CLIENTSECRET}")
  String clientSecret;

  @Option(
      names = {"--authType"},
      description = "auth type, only required for self-managed (default to KEYCLOAK)",
      scope = CommandLine.ScopeType.INHERIT,
      defaultValue = "${CAMUNDA_MODELER_CLIENT_AUTHTYPE:-KEYCLOAK}")
  Type authType;

  public static void main(String[] args) {
    new CommandLine(new CommandLineApp())
        .addSubcommand(InfoCommand.class)
        .addSubcommand(ListProjectsCommand.class)
        .addSubcommand(ListFilesCommand.class)
        .addSubcommand(DownloadFileCommand.class)
        .addSubcommand(DownloadProjectCommand.class)
        .execute(args);
  }

  private JsonMapper jsonMapper() {
    return new SdkObjectMapper();
  }

  private JwtCredential webModelerCredential() {
    return new JwtCredential(clientId, clientSecret, audience, authUrl);
  }

  private JwtConfig jwtConfig(JwtCredential webModelerCredential) {
    JwtConfig jwtConfig = new JwtConfig();
    jwtConfig.addProduct(Product.WEB_MODELER, webModelerCredential);
    return jwtConfig;
  }

  private IdentityConfiguration identityConfiguration() {
    return new IdentityConfiguration(
        baseUrl, authUrl, authUrl, clientId, clientSecret, audience, authType.name());
  }

  private Identity identity(IdentityConfiguration identityConfiguration) {
    return new Identity(identityConfiguration);
  }

  private IdentityContainer identityContainer(
      Identity identity, IdentityConfiguration identityConfiguration) {
    return new IdentityContainer(identity, identityConfiguration);
  }

  private IdentityConfig identityConfig(IdentityContainer identityContainer) {
    IdentityConfig identityConfig = new IdentityConfig();
    identityConfig.addProduct(Product.WEB_MODELER, identityContainer);
    return identityConfig;
  }

  private Authentication authentication(
      JsonMapper jsonMapper, JwtConfig jwtConfig, IdentityConfig identityConfig) {
    if (isSaas()) {
      return SaaSAuthentication.builder()
          .withJsonMapper(jsonMapper)
          .withJwtConfig(jwtConfig)
          .build();
    } else {
      return SelfManagedAuthentication.builder()
          .withJwtConfig(jwtConfig)
          .withIdentityConfig(identityConfig)
          .build();
    }
  }

  private boolean isSaas() {
    return authUrl.equals(SAAS_AUTH_URL);
  }

  private ApiClient buildApiClient() {
    if (token != null) {
      // legacy
      ApiClient apiClient = new ApiClient();
      apiClient.setBasePath(baseUrl);
      apiClient.setBearerToken(token);
      return apiClient;
    } else {
      JsonMapper jsonMapper = jsonMapper();
      JwtCredential webModelerCredential = webModelerCredential();
      JwtConfig jwtConfig = jwtConfig(webModelerCredential);
      IdentityConfiguration identityConfiguration = identityConfiguration();
      Identity identity = identity(identityConfiguration);
      IdentityContainer identityContainer = identityContainer(identity, identityConfiguration);
      IdentityConfig identityConfig = identityConfig(identityContainer);
      return ApiClientFactory.getInstance()
          .get(
              new ApiClientConfiguration(
                  baseUrl,
                  new WebModelerAuthInterceptor(
                      authentication(jsonMapper, jwtConfig, identityConfig))));
    }
  }

  protected CollaboratorsApi buildCollaboratorsClient() {
    return new CollaboratorsApi(buildApiClient());
  }

  protected FilesApi buildFilesClient() {
    return new FilesApi(buildApiClient());
  }

  protected FoldersApi buildFoldersClient() {
    return new FoldersApi(buildApiClient());
  }

  protected InfoApi buildInfoClient() {
    return new InfoApi(buildApiClient());
  }

  protected MilestonesApi buildMilestonesClient() {
    return new MilestonesApi(buildApiClient());
  }

  protected ProjectsApi buildProjectsClient() {
    return new ProjectsApi(buildApiClient());
  }
}
