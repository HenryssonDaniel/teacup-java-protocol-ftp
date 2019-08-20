package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.ftplet.DefaultFtplet;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.FtpletContext;
import org.apache.ftpserver.ftplet.FtpletResult;

class CommandListener extends DefaultFtplet {
  private static final Logger LOGGER = Factory.getLogger(CommandListener.class);

  @Override
  public FtpletResult afterCommand(FtpSession session, FtpRequest request, FtpReply reply)
      throws FtpException, IOException {
    LOGGER.log(Level.INFO, () -> "Reply: " + reply);
    return super.afterCommand(session, request, reply);
  }

  @Override
  public FtpletResult beforeCommand(FtpSession session, FtpRequest request)
      throws FtpException, IOException {
    LOGGER.log(
        Level.INFO, () -> "Request: " + request.getReceivedTime() + ' ' + request.getRequestLine());
    return super.beforeCommand(session, request);
  }

  @Override
  public void destroy() {
    LOGGER.log(Level.FINE, "Destroy");
    super.destroy();
  }

  @Override
  public void init(FtpletContext ftpletContext) throws FtpException {
    LOGGER.log(Level.FINE, "Init");
    super.init(ftpletContext);
  }

  @Override
  public FtpletResult onConnect(FtpSession session) throws FtpException, IOException {
    LOGGER.log(Level.FINE, "Connect");
    return super.onConnect(session);
  }

  @Override
  public FtpletResult onDisconnect(FtpSession session) throws FtpException, IOException {
    LOGGER.log(Level.FINE, "Disconnect");
    return super.onDisconnect(session);
  }
}
