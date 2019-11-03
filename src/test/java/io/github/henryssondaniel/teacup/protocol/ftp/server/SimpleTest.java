package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import io.github.henryssondaniel.teacup.protocol.Server;
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
  private final Object lock = new Object();
  private final Reply reply = mock(Reply.class);
  private final Reply replyDifferent = mock(Reply.class);
  private final Server<Context, Request> simpleServer = new Simple(ftpServer, handler);
  private final Object verifyLock = new Object();

  @Mock private Supplier<List<Request>> supplierNonExisting;
  private boolean waitVerify = true;
  private boolean waiting = true;

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
  void setContext() {
    simpleServer.setContext(context);

    verify(context).getReply();
    verifyNoMoreInteractions(context);

    verify(handler).setHandler(any());
    verify(handler).setReply(reply);
    verifyNoMoreInteractions(handler);

    verifyNoInteractions(reply);
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

  private Thread createThread(int code) {
    var thread =
        new Thread(
            () -> {
              doAnswer(invocationOnMock -> waiting(code)).when(replyDifferent).getCode();
              setSecondContext();
            });
    thread.start();
    return thread;
  }

  private void interrupt(Thread thread) throws InterruptedException {
    synchronized (lock) {
      while (waiting) lock.wait(1L);

      thread.interrupt();
    }
  }

  private void removeSupplier(Supplier<List<Request>> supplier) throws InterruptedException {
    synchronized (lock) {
      while (waiting) lock.wait(1L);

      simpleServer.removeSupplier(supplier);
    }
  }

  private void setSecondContext() {
    synchronized (verifyLock) {
      simpleServer.setContext(context);
      waitVerify = false;
      verifyLock.notifyAll();
    }
  }

  private Object waiting(Object object) {
    synchronized (lock) {
      waiting = false;
      lock.notifyAll();
    }

    return object;
  }
}
