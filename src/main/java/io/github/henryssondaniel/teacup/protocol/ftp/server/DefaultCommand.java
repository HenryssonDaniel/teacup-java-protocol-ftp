package io.github.henryssondaniel.teacup.protocol.ftp.server;

import io.github.henryssondaniel.teacup.core.logging.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ftpserver.command.Command;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.impl.FtpIoSession;
import org.apache.ftpserver.impl.FtpServerContext;
import org.apache.ftpserver.impl.LocalizedFtpReply;

class DefaultCommand implements Command {
  private static final Logger LOGGER = Factory.getLogger(DefaultCommand.class);

  @Override
  public void execute(
      FtpIoSession ftpIoSession, FtpServerContext ftpServerContext, FtpRequest ftpRequest) {
    ftpIoSession.resetState();

    LOGGER.log(
        Level.INFO,
        () -> "Request: " + ftpRequest.getReceivedTime() + ' ' + ftpRequest.getRequestLine());

    ftpIoSession.write(
        LocalizedFtpReply.translate(
            ftpIoSession,
            ftpRequest,
            ftpServerContext,
            FtpReply.REPLY_202_COMMAND_NOT_IMPLEMENTED,
            "ACCT",
            null));
  }
}
