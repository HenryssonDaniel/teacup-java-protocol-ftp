package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;

import org.apache.ftpserver.ftplet.DefaultFtpReply;
import org.apache.ftpserver.ftplet.FtpRequest;
import org.apache.ftpserver.impl.FtpIoSession;
import org.junit.jupiter.api.Test;

class HandlerImplTest {
  private final FtpIoSession ftpIoSession = mock(FtpIoSession.class);
  private final FtpRequest ftpRequest = mock(FtpRequest.class);
  private final Handler handler = new HandlerImpl();
  private final TimeoutSupplier timeoutSupplier = mock(TimeoutSupplier.class);

  @Test
  void addTimeoutSupplier() {
    handler.addTimeoutSupplier(timeoutSupplier);
    assertThat(handler.getTimeoutSuppliers()).containsExactly(timeoutSupplier);
  }

  @Test
  void getReply() {
    assertThat(handler.getReply()).isNull();
  }

  @Test
  void getTimeoutSuppliers() {
    assertThat(handler.getTimeoutSuppliers()).isEmpty();
  }

  @Test
  void messageReceived() throws Exception {
    var reply = mock(Reply.class);
    handler.setReply(reply);

    handler.addTimeoutSupplier(timeoutSupplier);
    handler.messageReceived(ftpIoSession, ftpRequest);

    verify(ftpIoSession).resetState();
    verify(ftpIoSession).write(any(DefaultFtpReply.class));
    verifyNoMoreInteractions(ftpIoSession);

    verify(ftpRequest).getArgument();
    verify(ftpRequest).getCommand();
    verify(ftpRequest).getReceivedTime();
    verify(ftpRequest).getRequestLine();
    verifyNoMoreInteractions(ftpRequest);

    verify(timeoutSupplier).addRequest(any(Request.class));
    verifyNoMoreInteractions(timeoutSupplier);
  }

  @Test
  void messageReceivedWhenNoReply() {
    assertThatNullPointerException()
        .isThrownBy(() -> handler.messageReceived(ftpIoSession, ftpRequest));

    verifyZeroInteractions(ftpIoSession);
    verifyZeroInteractions(ftpRequest);
  }

  @Test
  void removeTimeoutSupplier() {
    handler.addTimeoutSupplier(timeoutSupplier);
    handler.removeTimeoutSupplier(timeoutSupplier);
    assertThat(handler.getTimeoutSuppliers()).isEmpty();
  }
}
