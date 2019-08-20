package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import io.github.henryssondaniel.teacup.core.Server;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.ftplet.FtpException;
import org.junit.jupiter.api.Test;

class SimpleTest {
  private final FtpServer ftpServer = mock(FtpServer.class);
  private final Server server = new Simple(ftpServer);

  @Test
  void setUp() throws FtpException {
    server.setUp();
    verify(ftpServer).start();
    verifyNoMoreInteractions(ftpServer);
  }

  @Test
  void setUpWhenException() throws FtpException {
    doThrow(new FtpException("test")).when(ftpServer).start();

    server.setUp();

    verify(ftpServer).start();
    verifyNoMoreInteractions(ftpServer);
  }

  @Test
  void tearDown() {
    server.tearDown();
    verify(ftpServer).stop();
    verifyNoMoreInteractions(ftpServer);
  }
}
