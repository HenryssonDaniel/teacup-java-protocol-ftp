package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static java.util.Collections.singletonMap;

import io.github.henryssondaniel.teacup.protocol.ftp.SimpleServer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.FtpServerFactory;

public enum Factory {
  ;

  private static final Logger LOGGER =
      io.github.henryssondaniel.teacup.core.logging.Factory.getLogger(Factory.class);

  /**
   * Creates a new {@link SimpleServer}.
   *
   * @return the simple server
   * @since 1.0
   */
  public static SimpleServer createServer() {
    LOGGER.log(Level.FINE, "Create server");

    var ftpServerFactory = new FtpServerFactory();
    ftpServerFactory.setFtplets(singletonMap("Teacup command listener", new CommandListener()));

    return new Simple(ftpServerFactory.createServer());
  }
}
