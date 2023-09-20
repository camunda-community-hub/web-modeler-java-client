package org.camunda.community.webmodeler.cli;

import java.util.List;
import java.util.UUID;
import org.camunda.community.webmodeler.client.dto.FileMetadataDto;
import org.camunda.community.webmodeler.client.dto.PubSearchDtoFileMetadataDto;
import picocli.CommandLine;

@CommandLine.Command(
        name = "listFiles",
        description = "Prints out files in project (only metadata, no file contents).",
        mixinStandardHelpOptions = true)
public class ListFilesCommand extends AbstractCommand {

    @CommandLine.Option(
            names = {"--project", "-p"},
            description = "project UUID",
            scope = CommandLine.ScopeType.LOCAL,
            required = true)
    private UUID projectUUID;

    @CommandLine.Option(
            names = {"--page", "-pg"},
            description = "page number of the results to fetch, defaults to 0",
            scope = CommandLine.ScopeType.LOCAL)
    private int page;

    @Override
    public Integer call() throws Exception {
        PubSearchDtoFileMetadataDto searchDto = new PubSearchDtoFileMetadataDto()
                .size(CommandLineApp.MAX_PAGE_SIZE)
                .page(page)
                .filter(new FileMetadataDto().projectId(projectUUID.toString()));
        List<FileMetadataDto> projects =
                parent.buildFilesClient().searchFiles(searchDto).getItems();
        System.out.println(projects);
        return 0;
    }
}
