package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import io.github.henryssondaniel.teacup.protocol.ftp.SecureClient;
import javax.net.ssl.HostnameVerifier;
import org.apache.commons.net.ftp.FTPSClient;
import org.junit.jupiter.api.Test;

class SecureTest {
  private final FTPSClient ftpsClient = mock(FTPSClient.class);
  private final SecureClient secureClient = new Secure(ftpsClient);

  @Test
  void setEndpointCheckingEnabled() {
    secureClient.setEndpointCheckingEnabled(false);

    verify(ftpsClient).setEndpointCheckingEnabled(false);
    verifyNoMoreInteractions(ftpsClient);
  }

  @Test
  void setHostnameVerifier() {
    var hostnameVerifier = mock(HostnameVerifier.class);

    secureClient.setHostnameVerifier(hostnameVerifier);

    verify(ftpsClient).setHostnameVerifier(hostnameVerifier);
    verifyNoMoreInteractions(ftpsClient);
  }
}
