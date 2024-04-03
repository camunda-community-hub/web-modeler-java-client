package org.camunda.community.webmodeler.cli;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.concurrent.Callable;
import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;

@Command
public abstract class AbstractCommand implements Callable<Integer> {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
  @ParentCommand protected CommandLineApp parent;

  @Override
  public final Integer call() throws Exception {
    try {
      validate();
      Object response = createResponse();
      if (response != null) {
        print(response);
      }
    } catch (CommandException e) {
      return e.getReturnCode();
    } catch (Exception e) {
      e.printStackTrace(System.err);
      return 1;
    }
    return 0;
  }

  private void print(Object response) throws IOException {
    OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValue(System.out, response);
  }

  protected void validate() throws Exception {}

  protected abstract Object createResponse() throws Exception;
}
