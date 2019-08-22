package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.impl.DefaultFtpHandler;
import org.apache.ftpserver.impl.FtpIoSession;

class HandlerImpl extends DefaultFtpHandler implements Handler {
  private static final Logger LOGGER = Factory.getLogger(HandlerImpl.class);
  private static final String MESSAGE = "{0}ing the timeout supplier{1}";

  private final List<TimeoutSupplier> timeoutSuppliers = new LinkedList<>();

  private Reply reply;

  @Override
  public void addTimeoutSupplier(TimeoutSupplier timeoutSupplier) {
    LOGGER.log(Level.FINE, MESSAGE, new Object[] {"Add", ""});
    timeoutSuppliers.add(timeoutSupplier);
  }

  @Override
  public Reply getReply() {
    return reply;
  }

  @Override
  public List<TimeoutSupplier> getTimeoutSuppliers() {
    LOGGER.log(Level.FINE, MESSAGE, new Object[] {"Sett", "s"});
    return new ArrayList<>(timeoutSuppliers);
  }

  @Override
  public void messageReceived(FtpIoSession ftpIoSession, FtpRequest ftpRequest) {
    ftpIoSession.resetState();

    var receivedTime = ftpRequest.getReceivedTime();

    LOGGER.log(Level.INFO, () -> "Request: " + receivedTime + ' ' + ftpRequest.getRequestLine());

    Request request =
        new RequestImpl(ftpRequest.getArgument(), ftpRequest.getCommand(), receivedTime);
    for (var timeoutSupplier : timeoutSuppliers) timeoutSupplier.addRequest(request);

    ftpIoSession.write(new DefaultFtpReply(reply.getCode(), reply.getMessage()));
  }

  @Override
  public void removeTimeoutSupplier(TimeoutSupplier timeoutSupplier) {
    LOGGER.log(Level.FINE, MESSAGE, new Object[] {"Remov", ""});
    timeoutSuppliers.remove(timeoutSupplier);
  }

  @Override
  public void setReply(Reply reply) {
    this.reply = reply;
  }
}
