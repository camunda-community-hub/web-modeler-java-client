package org.camunda.community.webmodeler.cli;

import java.util.UUID;
import picocli.CommandLine;

@CommandLine.Command(
    name = "downloadFile",
    description = "Prints out file content.",
    mixinStandardHelpOptions = true)
public class DownloadFileCommand extends AbstractCommand {

  @CommandLine.Option(
      names = {"--file", "-f"},
      description = "file UUID",
      scope = CommandLine.ScopeType.LOCAL,
      required = true)
  UUID fileUUID;

  @Override
  protected Object createResponse() throws Exception {
    return parent.buildFilesClient().getFile(fileUUID);
  }
}
