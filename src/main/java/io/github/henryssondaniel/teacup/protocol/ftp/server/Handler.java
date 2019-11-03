package io.github.henryssondaniel.teacup.protocol.ftp.server;

import org.apache.ftpserver.impl.FtpHandler;

interface Handler extends FtpHandler {
  Reply getReply();

  void setHandler(
      io.github.henryssondaniel.teacup.protocol.server.Handler<? super Request> handler);

  void setReply(Reply reply);
}
