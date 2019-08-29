package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import org.junit.jupiter.api.Test;

class SecureTest {
  @Test
  void createSecureClient() {
    var secureClient = Factory.createSecureClient(false);
    secureClient.setEndpointCheckingEnabled(true);
    secureClient.setHostnameVerifier((hostname, sslSession) -> false);

    assertThat(secureClient).isExactlyInstanceOf(Secure.class);
  }

  @Test
  void createSecureClientSslContext() throws NoSuchAlgorithmException {
    assertThat(Factory.createSecureClient(false, SSLContext.getDefault()))
        .isExactlyInstanceOf(Secure.class);
  }

  @Test
  void createSecureClientWithProtocol() {
    assertThat(Factory.createSecureClient(false, "SSL")).isExactlyInstanceOf(Secure.class);
  }
}
