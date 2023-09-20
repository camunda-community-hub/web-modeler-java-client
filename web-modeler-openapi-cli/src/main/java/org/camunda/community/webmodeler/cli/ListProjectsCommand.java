package org.camunda.community.webmodeler.cli;

import java.util.List;
import org.camunda.community.webmodeler.client.dto.ProjectMetadataDto;
import org.camunda.community.webmodeler.client.dto.PubSearchDtoProjectMetadataDto;
import picocli.CommandLine;

@CommandLine.Command(
        name = "listProjects",
        description = "Prints out projects in the organization.",
        mixinStandardHelpOptions = true)
public class ListProjectsCommand extends AbstractCommand {

    @CommandLine.Option(
            names = {"--page", "-pg"},
            description = "page number of the results to fetch, defaults to 0",
            scope = CommandLine.ScopeType.LOCAL)
    private int page;

    @Override
    public Integer call() throws Exception {
        PubSearchDtoProjectMetadataDto searchDto = new PubSearchDtoProjectMetadataDto()
                .size(CommandLineApp.MAX_PAGE_SIZE)
                .page(page);
        List<ProjectMetadataDto> projects =
                parent.buildProjectsClient().searchProjects(searchDto).getItems();
        System.out.println(projects);
        return 0;
    }
}
