package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import io.github.henryssondaniel.teacup.protocol.ftp.Client;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPCmd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleTest {
  private static final int CODE = 100;
  private static final String TEST = "test";
  private static final String TEXT = "text";

  private final FTPClient ftpClient = mock(FTPClient.class);
  private final Client client = new Simple(ftpClient);

  @BeforeEach
  void beforeEach() throws IOException {
    when(ftpClient.getReplyString()).thenReturn(TEXT);

    when(ftpClient.sendCommand(FTPCmd.ABOR, null)).thenReturn(CODE);
    when(ftpClient.sendCommand(FTPCmd.ABORT, TEST)).thenReturn(CODE);
  }

  @Test
  void configure() {
    var configuration = mock(Configuration.class);

    client.configure(configuration);

    verify(configuration).getDefaultDateFormatString();
    verify(configuration).getRecentDateFormatString();
    verify(configuration).getServerLanguageCode();
    verify(configuration).getServerTimeZoneId();
    verify(configuration).getShortMonthNames();
    verify(configuration).getSystemKey();
    verify(configuration).hasLenientFutureDates();
    verify(configuration).shouldSaveUnparseableEntries();
    verifyNoMoreInteractions(configuration);

    verify(ftpClient).configure(any(FTPClientConfig.class));
    verifyNoMoreInteractions(ftpClient);
  }

  @Test
  void connect() throws IOException {
    var hostname = "localhost";
    client.connect(hostname);

    verify(ftpClient).getDefaultPort();
    verify(ftpClient).connect(hostname, 0);
    verifyNoMoreInteractions(ftpClient);
  }

  @Test
  void disconnect() throws IOException {
    client.disconnect();
    verify(ftpClient).disconnect();
    verifyNoMoreInteractions(ftpClient);
  }

  @Test
  void send() throws IOException {
    var response = client.send(Command.ABOR);

    assertThat(response.getCode()).isSameAs(CODE);
    assertThat(response.getText()).isSameAs(TEXT);

    verify(ftpClient).getReplyString();
    verify(ftpClient).sendCommand(FTPCmd.ABOR, null);
    verifyNoMoreInteractions(ftpClient);
  }

  @Test
  void sendWithCommand() throws IOException {
    var response = client.send(Command.ABORT, TEST);

    assertThat(response.getCode()).isSameAs(CODE);
    assertThat(response.getText()).isSameAs(TEXT);

    verify(ftpClient).getReplyString();
    verify(ftpClient).sendCommand(FTPCmd.ABORT, TEST);
    verifyNoMoreInteractions(ftpClient);
  }
}
