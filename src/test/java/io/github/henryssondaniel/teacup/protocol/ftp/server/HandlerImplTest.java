package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.MockitoAnnotations.initMocks;

import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.impl.FtpIoSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HandlerImplTest {
  private final FtpIoSession ftpIoSession = mock(FtpIoSession.class);
  private final FtpRequest ftpRequest = mock(FtpRequest.class);
  private final Handler handler = new HandlerImpl();

  @BeforeEach
  void beforeEach() {
    initMocks(this);
  }

  @Test
  void getReply() {
    assertThat(handler.getReply()).isNull();
  }

  @Test
  void messageReceived() throws Exception {
    var reply = mock(Reply.class);
    handler.setReply(reply);

    handler.messageReceived(ftpIoSession, ftpRequest);

    verify(ftpIoSession).resetState();
    verify(ftpIoSession).write(any(DefaultFtpReply.class));
    verifyNoMoreInteractions(ftpIoSession);

    verify(ftpRequest).getReceivedTime();
    verify(ftpRequest).getRequestLine();
    verifyNoMoreInteractions(ftpRequest);
  }

  @Test
  void messageReceivedWhenNoReply() {
    assertThatNullPointerException()
        .isThrownBy(() -> handler.messageReceived(ftpIoSession, ftpRequest));

    verifyNoInteractions(ftpIoSession);
    verifyNoInteractions(ftpRequest);
  }
}
