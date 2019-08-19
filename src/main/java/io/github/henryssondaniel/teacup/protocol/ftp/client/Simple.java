package io.github.henryssondaniel.teacup.protocol.ftp.client;

import io.github.henryssondaniel.teacup.protocol.ftp.Client;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPCmd;

class Simple implements Client {
  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(Simple.class);
  private final FTP ftp = new FTPClient();

  @Override
  public Response send(Command command) throws IOException {
    LOGGER.log(Level.FINE, "Send");
    return send(command, null);
  }

  @Override
  public Response send(Command command, String argument) throws IOException {
    LOGGER.log(Level.FINE, "Send");
    return send(command.toString(), argument);
  }

  @Override
  public Response send(String command) throws IOException {
    LOGGER.log(Level.FINE, "Send");
    return send(command, null);
  }

  @Override
  public Response send(String command, String argument) throws IOException {
    LOGGER.log(Level.FINE, "Send");
    return new ResponseImpl(ftp.sendCommand(FTPCmd.valueOf(command)), ftp.getReplyString());
  }
}
