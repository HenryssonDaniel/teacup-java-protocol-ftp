package io.github.henryssondaniel.teacup.protocol.ftp.client;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.ftp.Client;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPCmd;

class Simple implements Client {
  private static final Logger LOGGER = Factory.getLogger(Simple.class);
  private final FTP ftp;

  Simple(FTP ftp) {
    this.ftp = ftp;
  }

  @Override
  public void connect(String hostname) throws IOException {
    LOGGER.log(Level.FINE, "Connect");
    connect(hostname, ftp.getDefaultPort());
  }

  @Override
  public void connect(String hostname, int port) throws IOException {
    LOGGER.log(Level.FINE, "Connect");
    ftp.connect(hostname, port);
  }

  @Override
  public void disconnect() throws IOException {
    LOGGER.log(Level.FINE, "Disconnect");
    ftp.disconnect();
  }

  @Override
  public Response send(Command command) throws IOException {
    LOGGER.log(Level.FINE, "Send");
    return send(command, null);
  }

  @Override
  public Response send(Command command, String argument) throws IOException {
    LOGGER.log(Level.FINE, "Send");
    return send(command.name(), argument);
  }

  @Override
  public Response send(String command) throws IOException {
    LOGGER.log(Level.FINE, "Send");
    return send(command, null);
  }

  @Override
  public Response send(String command, String argument) throws IOException {
    LOGGER.log(Level.FINE, "Send");

    LOGGER.log(Level.INFO, getRequest(argument, command));

    var code = ftp.sendCommand(FTPCmd.valueOf(command), argument);
    var text = ftp.getReplyString();

    LOGGER.log(Level.INFO, () -> "Response: " + code + ' ' + text);

    return new ResponseImpl(code, text);
  }

  private static String getRequest(String argument, String command) {
    var stringBuilder = new StringBuilder("Request: " + command);
    if (argument != null) stringBuilder.append(' ').append(argument);

    return stringBuilder.toString();
  }
}
