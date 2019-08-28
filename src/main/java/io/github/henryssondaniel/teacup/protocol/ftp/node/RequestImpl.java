package io.github.henryssondaniel.teacup.protocol.ftp.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.ftp.server.Request;
import java.util.logging.Level;
import java.util.logging.Logger;

class RequestImpl extends SetterImpl<Request, GenericObjectAssert<Request, ?>>
    implements RequestSetter {
  private static final Logger LOGGER = Factory.getLogger(RequestImpl.class);

  private GenericObjectAssert<String, ?> argument;
  private GenericObjectAssert<String, ?> command;
  private GenericObjectAssert<Long, ?> receivedTime;

  @Override
  public void setArgument(GenericStringAssert<?> argument) {
    LOGGER.log(Level.FINE, "Set argument");
    this.argument = argument;
  }

  @Override
  public void setCommand(GenericStringAssert<?> command) {
    LOGGER.log(Level.FINE, "Set command");
    this.command = command;
  }

  @Override
  public void setReceivedTime(GenericLongAssert<?> receivedTime) {
    LOGGER.log(Level.FINE, "Set received time");
    this.receivedTime = receivedTime;
  }

  @Override
  public void verify(Request request) {
    LOGGER.log(Level.FINE, "Verify");

    if (argument != null) argument.verify(request.getArgument());
    if (command != null) command.verify(request.getCommand());
    if (receivedTime != null) receivedTime.verify(request.getReceivedTime());
  }
}
