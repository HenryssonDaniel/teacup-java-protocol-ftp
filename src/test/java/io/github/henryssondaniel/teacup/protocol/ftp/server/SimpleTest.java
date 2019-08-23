package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import io.github.henryssondaniel.teacup.protocol.ftp.SimpleServer;
import java.util.List;
import java.util.function.Supplier;
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
  private final SimpleServer simpleServer = new Simple(ftpServer, handler);
  private final TimeoutSupplier timeoutSupplier = mock(TimeoutSupplier.class);

  @Mock private Supplier<List<Request>> supplierNonExisting;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);

    when(context.getReply()).thenReturn(reply);
    when(reply.getMessage()).thenReturn("message");
  }

  @Test
  void removeSupplier() {
    simpleServer.removeSupplier(supplierNonExisting);
    verifyZeroInteractions(supplierNonExisting);
  }

  @Test
  void removeSupplierWhenTimeoutSupplier() {
    simpleServer.removeSupplier(timeoutSupplier);
    verify(timeoutSupplier).stop();
  }

  @Test
  void setContext() {
    simpleServer.setContext(context);

    verify(context).getReply();
    verifyNoMoreInteractions(context);

    verify(handler).addTimeoutSupplier(any(TimeoutSupplier.class));
    verify(handler).getReply();
    verify(handler).setReply(reply);
    verifyNoMoreInteractions(handler);

    verifyZeroInteractions(reply);
  }

  @Test
  void setContextWhenDuplicateContext() {
    when(handler.getReply()).thenReturn(reply);

    simpleServer.setContext(context);

    verify(context).getReply();
    verifyNoMoreInteractions(context);

    verify(handler).addTimeoutSupplier(any(TimeoutSupplier.class));
    verify(handler).getReply();
    verifyNoMoreInteractions(handler);

    verify(reply, times(2)).getCode();
    verify(reply, times(2)).getMessage();
    verifyNoMoreInteractions(reply);
  }

  @Test
  void setUp() throws FtpException {
    simpleServer.setUp();
    verify(ftpServer).start();
    verifyNoMoreInteractions(ftpServer);
  }

  @Test
  void setUpWhenException() throws FtpException {
    doThrow(new FtpException("test")).when(ftpServer).start();

    simpleServer.setUp();

    verify(ftpServer).start();
    verifyNoMoreInteractions(ftpServer);
  }

  @Test
  void tearDown() {
    simpleServer.tearDown();
    verify(ftpServer).stop();
    verifyNoMoreInteractions(ftpServer);
  }
}
