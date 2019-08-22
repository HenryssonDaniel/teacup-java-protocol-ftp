package io.github.henryssondaniel.teacup.protocol.ftp.server;

class RequestImpl implements Request {
  private final String argument;
  private final String command;
  private final long receivedTime;

  RequestImpl(String argument, String command, long receivedTime) {
    this.argument = argument;
    this.command = command;
    this.receivedTime = receivedTime;
  }

  @Override
  public String getArgument() {
    return argument;
  }

  @Override
  public String getCommand() {
    return command;
  }

  @Override
  public long getReceivedTime() {
    return receivedTime;
  }
}
