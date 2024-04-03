package org.camunda.community.webmodeler.cli;

public class CommandException extends Exception {
  private final int returnCode;

  public CommandException(String message, Throwable cause, int returnCode) {
    super(message, cause);
    this.returnCode = returnCode;
  }

  public CommandException(String message, int returnCode) {
    super(message);
    this.returnCode = returnCode;
  }

  public int getReturnCode() {
    return returnCode;
  }
}
