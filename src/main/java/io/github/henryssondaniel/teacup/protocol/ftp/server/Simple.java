package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import io.github.henryssondaniel.teacup.protocol.server.Base;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.FtpException;

class Simple extends Base<Context, Handler, Request> {
  private static final Logger LOGGER = Factory.getLogger(Simple.class);

  private final FtpServer ftpServer;
  private final Handler handler;

  Simple(FtpServer ftpServer, Handler handler) {
    this.ftpServer = ftpServer;
    this.handler = handler;
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

  @Override
  protected Handler createProtocolContext(
      Context context, io.github.henryssondaniel.teacup.protocol.server.Handler<Request> handler1) {
    handler.setHandler(handler1);
    handler.setReply(context.getReply());

    return handler;
  }

  @Override
  protected String getKey(Context context) {
    return "key";
  }

  @Override
  protected boolean isEquals(Context context, Handler protocolContext) {
    var currentReply = context.getReply();
    var reply = protocolContext.getReply();

    return currentReply.getCode() == reply.getCode()
        && currentReply.getMessage().equals(reply.getMessage());
  }

  @Override
  protected void serverCleanup(Handler protocolContext) {
    protocolContext.setReply(null);
  }
}
