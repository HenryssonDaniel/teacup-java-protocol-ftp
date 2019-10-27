package io.github.henryssondaniel.teacup.protocol.ftp.server;

import org.apache.ftpserver.impl.FtpHandler;

interface Handler
    extends FtpHandler, io.github.henryssondaniel.teacup.protocol.server.Handler<Request> {
  Reply getReply();

  void setReply(Reply reply);
}
