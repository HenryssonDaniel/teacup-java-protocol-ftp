package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.FtpException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SimpleTest {
  private final Context context = mock(Context.class);
  private final FtpServer ftpServer = mock(FtpServer.class);
  private final Handler handler = mock(Handler.class);
  private final Reply reply = mock(Reply.class);
  private final Simple simple = new Simple(ftpServer, handler);

  @Mock private io.github.henryssondaniel.teacup.protocol.server.Handler<Request> handlerRequest;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);

    when(context.getReply()).thenReturn(reply);
    when(handler.getReply()).thenReturn(reply);
    when(reply.getMessage()).thenReturn("message");
  }

  @Test
  void createProtocolContext() {
    simple.createProtocolContext(context, handlerRequest);

    verify(context).getReply();
    verifyNoMoreInteractions(context);

    verifyNoInteractions(ftpServer);

    verify(handler).setHandler(handlerRequest);
    verify(handler).setReply(reply);
    verifyNoMoreInteractions(handler);

    verifyNoInteractions(handlerRequest);
  }

  @Test
  void getKey() {
    assertThat(simple.getKey(context)).isEqualTo("key");

    verifyNoInteractions(context);
    verifyNoInteractions(ftpServer);
    verifyNoInteractions(handler);
  }

  @Test
  void isEquals() {
    assertThat(simple.isEquals(context, handler)).isTrue();

    verify(context).getReply();
    verifyNoMoreInteractions(context);

    verifyNoInteractions(ftpServer);

    verify(handler).getReply();
    verifyNoMoreInteractions(handler);
  }

  @Test
  void isEqualsWhenNotEqualCode() {
    when(reply.getCode()).thenReturn(1, 0);

    assertThat(simple.isEquals(context, handler)).isFalse();

    verify(context).getReply();
    verifyNoMoreInteractions(context);

    verifyNoInteractions(ftpServer);

    verify(handler).getReply();
    verifyNoMoreInteractions(handler);
  }

  @Test
  void isEqualsWhenNotEqualMessage() {
    when(reply.getMessage()).thenReturn("1", "0");

    assertThat(simple.isEquals(context, handler)).isFalse();

    verify(context).getReply();
    verifyNoMoreInteractions(context);

    verifyNoInteractions(ftpServer);

    verify(handler).getReply();
    verifyNoMoreInteractions(handler);
  }

  @Test
  void serverCleanup() {
    simple.serverCleanup(handler);

    verifyNoInteractions(ftpServer);

    verify(handler).setReply(null);
    verifyNoMoreInteractions(handler);
  }

  @Test
  void setUp() throws FtpException {
    simple.setUp();

    verify(ftpServer).start();
    verifyNoMoreInteractions(ftpServer);

    verifyNoInteractions(handler);
  }

  @Test
  void setUpWhenException() throws FtpException {
    doThrow(new FtpException("test")).when(ftpServer).start();

    simple.setUp();

    verify(ftpServer).start();
    verifyNoMoreInteractions(ftpServer);

    verifyNoInteractions(handler);
  }

  @Test
  void tearDown() {
    simple.tearDown();

    verify(ftpServer).stop();
    verifyNoMoreInteractions(ftpServer);

    verifyNoInteractions(handler);
  }
}
