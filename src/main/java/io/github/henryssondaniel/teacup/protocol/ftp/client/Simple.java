package io.github.henryssondaniel.teacup.protocol.ftp.client;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.ftp.Client;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPCmd;

class Simple implements Client {
  private static final Logger LOGGER = Factory.getLogger(Simple.class);
  private final FTPClient ftpClient;

  Simple(FTPClient ftpClient) {
    this.ftpClient = ftpClient;
  }

  @Override
  public void configure(Configuration configuration) {
    ftpClient.configure(
        new FTPClientConfig(
            configuration.getSystemKey(),
            configuration.getDefaultDateFormatString(),
            configuration.getRecentDateFormatString(),
            configuration.getServerLanguageCode(),
            configuration.getShortMonthNames(),
            configuration.getServerTimeZoneId(),
            configuration.hasLenientFutureDates(),
            configuration.shouldSaveUnparseableEntries()));
  }

  @Override
  public void connect(String hostname, int port) throws IOException {
    LOGGER.log(Level.FINE, "Connect");
    ftpClient.connect(hostname, port);
  }

  @Override
  public void connect(String hostname) throws IOException {
    LOGGER.log(Level.FINE, "Connect");
    connect(hostname, ftpClient.getDefaultPort());
  }

  @Override
  public void disconnect() throws IOException {
    LOGGER.log(Level.FINE, "Disconnect");
    ftpClient.disconnect();
  }

  @Override
  public Response send(Command command, String argument) throws IOException {
    LOGGER.log(Level.FINE, "Send");

    var cmd = command.name();

    LOGGER.log(Level.INFO, getRequest(argument, cmd));

    var code = ftpClient.sendCommand(FTPCmd.valueOf(cmd), argument);
    var text = ftpClient.getReplyString();

    LOGGER.log(Level.INFO, () -> "Response: " + code + ' ' + text);

    return new ResponseImpl(code, text);
  }

  @Override
  public Response send(Command command) throws IOException {
    LOGGER.log(Level.FINE, "Send");
    return send(command, null);
  }

  private static String getRequest(String argument, String command) {
    var stringBuilder = new StringBuilder("Request: " + command);
    if (argument != null) stringBuilder.append(' ').append(argument);

    return stringBuilder.toString();
  }
}
