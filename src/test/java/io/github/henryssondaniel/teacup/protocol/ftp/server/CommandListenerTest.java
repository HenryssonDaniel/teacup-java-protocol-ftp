package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.io.IOException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.FtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.ftplet.FtpSession;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.ftplet.FtpletContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandListenerTest {
  private final FtpRequest ftpRequest = mock(FtpRequest.class);
  private final FtpSession ftpSession = mock(FtpSession.class);
  private final Ftplet ftplet = new CommandListener();

  @Test
  void afterCommand() throws FtpException, IOException {
    var ftpReply = mock(FtpReply.class);

    assertThat(ftplet.afterCommand(ftpSession, ftpRequest, ftpReply)).isNull();

    verifyZeroInteractions(ftpSession);

    verify(ftpRequest).getCommand();
    verifyNoMoreInteractions(ftpRequest);

    verifyZeroInteractions(ftpReply);
  }

  @Test
  void beforeCommand() throws FtpException, IOException {
    when(ftpRequest.getReceivedTime()).thenReturn(1L);
    when(ftpRequest.getRequestLine()).thenReturn("requestLine");

    assertThat(ftplet.beforeCommand(ftpSession, ftpRequest)).isNull();

    verifyZeroInteractions(ftpSession);

    verify(ftpRequest).getCommand();
    verify(ftpRequest).getReceivedTime();
    verify(ftpRequest).getRequestLine();
    verifyNoMoreInteractions(ftpRequest);
  }

  @BeforeEach
  void beforeEach() {
    when(ftpRequest.getCommand()).thenReturn("command");
  }

  @Test
  void initAndDestroy() throws FtpException {
    var ftpletContext = mock(FtpletContext.class);
    ftplet.init(ftpletContext);
    ftplet.destroy();
    verifyZeroInteractions(ftpSession);
  }

  @Test
  void onConnect() throws FtpException, IOException {
    assertThat(ftplet.onConnect(ftpSession)).isNull();
    verifyZeroInteractions(ftpSession);
  }

  @Test
  void onDisconnect() throws FtpException, IOException {
    assertThat(ftplet.onDisconnect(ftpSession)).isNull();
    verifyZeroInteractions(ftpSession);
  }
}
