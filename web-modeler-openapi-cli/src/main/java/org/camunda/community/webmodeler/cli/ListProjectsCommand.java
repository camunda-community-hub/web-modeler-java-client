package org.camunda.community.webmodeler.cli;

import java.util.List;
import org.camunda.community.webmodeler.client.dto.ProjectMetadataDto;
import picocli.CommandLine;

@CommandLine.Command(
        name = "listProjects",
        description = "Prints out projects in the organization.",
        mixinStandardHelpOptions = true)
public class ListProjectsCommand extends AbstractCommand {
    @Override
    public Integer call() throws Exception {
        List<ProjectMetadataDto> projects = parent.buildProjectsClient().listProjects();
        System.out.println(projects);
        return 0;
    }
}
