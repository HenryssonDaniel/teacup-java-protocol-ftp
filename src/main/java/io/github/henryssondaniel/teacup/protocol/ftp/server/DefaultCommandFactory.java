package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.command.Command;
import org.apache.ftpserver.command.CommandFactory;

class DefaultCommandFactory implements CommandFactory {
  private static final Logger LOGGER = Factory.getLogger(DefaultCommandFactory.class);
  private final Command command = new DefaultCommand();

  @Override
  public Command getCommand(String commandName) {
    LOGGER.log(Level.FINE, "Get command");
    return command;
  }
}
