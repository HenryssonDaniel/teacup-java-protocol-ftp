package io.github.henryssondaniel.teacup.protocol.ftp.server;

import java.util.List;
import org.apache.ftpserver.impl.FtpHandler;

interface Handler extends FtpHandler {
  void addTimeoutSupplier(TimeoutSupplier timeoutSupplier);

  Reply getReply();

  List<TimeoutSupplier> getTimeoutSuppliers();

  void removeTimeoutSupplier(TimeoutSupplier timeoutSupplier);

  void setReply(Reply reply);
}
