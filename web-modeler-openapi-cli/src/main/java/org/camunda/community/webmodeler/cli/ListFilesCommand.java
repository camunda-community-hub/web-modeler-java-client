package org.camunda.community.webmodeler.cli;

import java.util.List;
import java.util.UUID;
import org.camunda.community.webmodeler.client.dto.FileMetadataDto;
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

    @Override
    public Integer call() throws Exception {
        List<FileMetadataDto> projects = parent.buildFilesClient().listFiles(projectUUID);
        System.out.println(projects);
        return 0;
    }
}
