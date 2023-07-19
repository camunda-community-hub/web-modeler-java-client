package org.camunda.community.webmodeler.cli;

import org.camunda.community.webmodeler.client.dto.InfoDto;
import picocli.CommandLine;

@CommandLine.Command(
        name = "info",
        description = "Prints out info (permissions, authorized organization).",
        mixinStandardHelpOptions = true)
public class InfoCommand extends AbstractCommand {
    @Override
    public Integer call() throws Exception {
        InfoDto info = parent.buildInfoClient().getInfo();
        System.out.println(info);
        return 0;
    }
}
