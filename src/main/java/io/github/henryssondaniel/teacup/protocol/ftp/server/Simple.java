package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.ftp.SimpleServer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.FtpException;

class Simple implements SimpleServer {
  private static final Logger LOGGER = Factory.getLogger(Simple.class);
  private final FtpServer ftpServer;

  Simple(FtpServer ftpServer) {
    this.ftpServer = ftpServer;
  }

  @Override
  public void setUp() {
    LOGGER.log(Level.FINE, "Set up");

    try {
      ftpServer.start();
    } catch (FtpException e) {
      LOGGER.log(Level.FINE, "Could not start the server", e);
    }
  }

  @Override
  public void tearDown() {
    LOGGER.log(Level.FINE, "Tear down");
    ftpServer.stop();
  }
}
