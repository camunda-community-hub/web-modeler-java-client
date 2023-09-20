package org.camunda.community.webmodeler.cli;

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
            scope = CommandLine.ScopeType.INHERIT,
            required = true)
    private String token;

    @Option(
            names = {"--basePath", "-b"},
            description = "base path of API (default to Camunda Cloud path)",
            scope = CommandLine.ScopeType.INHERIT)
    private String basePath = new ApiClient().getBasePath();

    protected CollaboratorsApi buildCollaboratorsClient() {
        CollaboratorsApi result = new CollaboratorsApi();
        ApiClient apiClient = result.getApiClient();
        configureClient(apiClient);
        return result;
    }

    protected FilesApi buildFilesClient() {
        FilesApi result = new FilesApi();
        ApiClient apiClient = result.getApiClient();
        configureClient(apiClient);
        return result;
    }

    protected FoldersApi buildFoldersClient() {
        FoldersApi result = new FoldersApi();
        ApiClient apiClient = result.getApiClient();
        configureClient(apiClient);
        return result;
    }

    protected InfoApi buildInfoClient() {
        InfoApi result = new InfoApi();
        ApiClient apiClient = result.getApiClient();
        configureClient(apiClient);
        return result;
    }

    protected MilestonesApi buildMilestonesClient() {
        MilestonesApi result = new MilestonesApi();
        ApiClient apiClient = result.getApiClient();
        configureClient(apiClient);
        return result;
    }

    protected ProjectsApi buildProjectsClient() {
        ProjectsApi result = new ProjectsApi();
        ApiClient apiClient = result.getApiClient();
        configureClient(apiClient);
        return result;
    }

    private void configureClient(ApiClient apiClient) {
        apiClient.setBearerToken(token);
        apiClient.setBasePath(basePath);
    }

    public static void main(String[] args) {
        new CommandLine(new CommandLineApp())
                .addSubcommand(InfoCommand.class)
                .addSubcommand(ListProjectsCommand.class)
                .addSubcommand(ListFilesCommand.class)
                .addSubcommand(DownloadFileCommand.class)
                .addSubcommand(DownloadProjectCommand.class)
                .execute(args);
    }
}
