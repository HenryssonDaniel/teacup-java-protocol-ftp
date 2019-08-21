package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.impl.FtpIoSession;
import org.apache.ftpserver.impl.FtpServerContext;
import org.apache.ftpserver.impl.LocalizedFtpReply;
import org.junit.jupiter.api.Test;

class DefaultCommandTest {
  private final DefaultCommand defaultCommand = new DefaultCommand();

  @Test
  void execute() {
    FtpIoSession ftpIoSession = mock(FtpIoSession.class);
    FtpServerContext ftpServerContext = mock(FtpServerContext.class);
    FtpRequest ftpRequest = mock(FtpRequest.class);

    defaultCommand.execute(ftpIoSession, ftpServerContext, ftpRequest);

    verify(ftpIoSession).getLanguage();
    verify(ftpIoSession).resetState();
    verify(ftpIoSession).write(any(LocalizedFtpReply.class));
    verifyNoMoreInteractions(ftpIoSession);

    verify(ftpServerContext).getMessageResource();
    verifyNoMoreInteractions(ftpServerContext);

    verify(ftpRequest).getReceivedTime();
    verify(ftpRequest).getRequestLine();
    verifyNoMoreInteractions(ftpRequest);
  }
}
