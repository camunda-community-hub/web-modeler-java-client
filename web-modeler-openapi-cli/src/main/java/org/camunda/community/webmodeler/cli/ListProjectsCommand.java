package org.camunda.community.webmodeler.cli;

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
  int page;

  @Override
  protected Object createResponse() throws Exception {
    PubSearchDtoProjectMetadataDto searchDto =
        new PubSearchDtoProjectMetadataDto().size(CommandLineApp.MAX_PAGE_SIZE).page(page);
    return parent.buildProjectsClient().searchProjects(searchDto).getItems();
  }
}
