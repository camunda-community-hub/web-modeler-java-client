package org.camunda.community.webmodeler.cli;

import picocli.CommandLine;

@CommandLine.Command(
    name = "info",
    description = "Prints out info (permissions, authorized organization).",
    mixinStandardHelpOptions = true)
public class InfoCommand extends AbstractCommand {

  @Override
  protected Object createResponse() throws Exception {
    return parent.buildInfoClient().getInfo();
  }
}
