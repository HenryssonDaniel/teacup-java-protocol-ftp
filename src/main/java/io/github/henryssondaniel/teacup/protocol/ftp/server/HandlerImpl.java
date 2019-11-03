package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.impl.DefaultFtpHandler;
import org.apache.ftpserver.impl.FtpIoSession;

class HandlerImpl extends DefaultFtpHandler implements Handler {
  private static final Logger LOGGER = Factory.getLogger(HandlerImpl.class);

  private io.github.henryssondaniel.teacup.protocol.server.Handler<? super Request> handler;
  private Reply reply;

  @Override
  public Reply getReply() {
    return reply;
  }

  @Override
  public void messageReceived(FtpIoSession ftpIoSession, FtpRequest ftpRequest) {
    Objects.requireNonNull(reply, "The reply is not set");

    ftpIoSession.resetState();

    var receivedTime = ftpRequest.getReceivedTime();

    LOGGER.log(Level.INFO, () -> "Request: " + receivedTime + ' ' + ftpRequest.getRequestLine());

    if (handler != null)
      handler.addRequest(
          new RequestImpl(ftpRequest.getArgument(), ftpRequest.getCommand(), receivedTime));

    ftpIoSession.write(new DefaultFtpReply(reply.getCode(), reply.getMessage()));
  }

  @Override
  public void setHandler(
      io.github.henryssondaniel.teacup.protocol.server.Handler<? super Request> handler) {
    this.handler = handler;
  }

  @Override
  public void setReply(Reply reply) {
    this.reply = reply;
  }
}
