package org.camunda.community.webmodeler.client.springboot;

import org.camunda.community.webmodeler.client.api.CollaboratorsApi;
import org.camunda.community.webmodeler.client.api.FilesApi;
import org.camunda.community.webmodeler.client.api.FoldersApi;
import org.camunda.community.webmodeler.client.api.InfoApi;
import org.camunda.community.webmodeler.client.api.MilestonesApi;
import org.camunda.community.webmodeler.client.api.ProjectsApi;
import org.camunda.community.webmodeler.client.invoker.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class CamundaWebModelerApi {

  private final ApiClient apiClient;

  @Autowired
  public CamundaWebModelerApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  @Bean
  public CollaboratorsApi collaboratorsApi() {
    return new CollaboratorsApi(apiClient);
  }

  @Bean
  public FilesApi filesApi() {
    return new FilesApi(apiClient);
  }

  @Bean
  public FoldersApi foldersApi() {
    return new FoldersApi(apiClient);
  }

  @Bean
  public InfoApi conditionApi() {
    return new InfoApi();
  }

  @Bean
  public MilestonesApi milestonesApi() {
    return new MilestonesApi(apiClient);
  }

  @Bean
  public ProjectsApi projectsApi() {
    return new ProjectsApi(apiClient);
  }
}
