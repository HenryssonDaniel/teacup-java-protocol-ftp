package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.henryssondaniel.teacup.protocol.ftp.Client;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPCmd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleTest {
  private static final int CODE = 100;
  private static final String TEXT = "text";

  private final FTPClient ftpClient = mock(FTPClient.class);
  private final Client client = new Simple(ftpClient);

  @BeforeEach
  void beforeEach() throws IOException {
    when(ftpClient.getReplyString()).thenReturn(TEXT);

    when(ftpClient.sendCommand(FTPCmd.ABOR, null)).thenReturn(CODE);
    when(ftpClient.sendCommand(FTPCmd.ABORT, "test")).thenReturn(CODE);
  }

  @Test
  void send() throws IOException {
    var response = client.send(Command.ABOR);

    assertThat(response.getCode()).isSameAs(CODE);
    assertThat(response.getText()).isSameAs(TEXT);

    verify(ftpClient).sendCommand(FTPCmd.ABOR, null);
  }

  @Test
  void sendString() throws IOException {
    var response = client.send(Command.ABOR.name());

    assertThat(response.getCode()).isSameAs(CODE);
    assertThat(response.getText()).isSameAs(TEXT);

    verify(ftpClient).sendCommand(FTPCmd.ABOR, null);
  }

  @Test
  void sendWithCommand() throws IOException {
    var response = client.send(Command.ABORT, "test");

    assertThat(response.getCode()).isSameAs(CODE);
    assertThat(response.getText()).isSameAs(TEXT);

    verify(ftpClient).sendCommand(FTPCmd.ABORT, "test");
  }
}
