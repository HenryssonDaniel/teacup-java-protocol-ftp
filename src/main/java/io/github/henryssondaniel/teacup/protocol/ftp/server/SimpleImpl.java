package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.server.Base;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.FtpException;

class SimpleImpl extends Base<Context, Handler, Request> implements SimpleBase {
  private static final Logger LOGGER = Factory.getLogger(SimpleImpl.class);

  private final FtpServer ftpServer;
  private final Handler handler;

  SimpleImpl(FtpServer ftpServer, Handler handler) {
    this.ftpServer = ftpServer;
    this.handler = handler;
  }

  @Override
  public Handler createProtocolContext(
      Context context,
      io.github.henryssondaniel.teacup.protocol.server.Handler<Request> requestHandler) {
    LOGGER.log(Level.FINE, "Create protocol context");

    handler.setHandler(requestHandler);
    handler.setReply(context.getReply());

    return handler;
  }

  @Override
  public String getKey(Context context) {
    LOGGER.log(Level.FINE, "Get key");
    return "key";
  }

  @Override
  public boolean isEquals(Context context, Handler protocolContext) {
    LOGGER.log(Level.FINE, "Is equals");

    var currentReply = context.getReply();
    var reply = protocolContext.getReply();

    return currentReply.getCode() == reply.getCode()
        && currentReply.getMessage().equals(reply.getMessage());
  }

  @Override
  public void serverCleanup(Handler protocolContext) {
    LOGGER.log(Level.FINE, "Server cleanup");
    protocolContext.setReply(null);
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
