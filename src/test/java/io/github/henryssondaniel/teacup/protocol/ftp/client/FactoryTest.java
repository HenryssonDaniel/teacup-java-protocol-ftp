package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoInteractions;

import javax.net.ssl.SSLContext;
import org.junit.jupiter.api.Test;

class FactoryTest {
  @Test
  void createClient() {
    assertThat(Factory.createClient()).isExactlyInstanceOf(Simple.class);
  }

  @Test
  void createConfigurationBuilder() {
    assertThat(Factory.createConfigurationBuilder("test"))
        .isExactlyInstanceOf(ConfigurationBuilderImpl.class);
  }

  @Test
  void createSecureClient() {
    assertThat(Factory.createSecureClient(false)).isExactlyInstanceOf(Secure.class);
  }

  @Test
  void createSecureClientSslContext() {
    var sslContext = mock(SSLContext.class);
    assertThat(Factory.createSecureClient(false, sslContext)).isExactlyInstanceOf(Secure.class);

    verifyNoInteractions(sslContext);
  }

  @Test
  void createSecureClientWithProtocol() {
    assertThat(Factory.createSecureClient(false, "SSL")).isExactlyInstanceOf(Secure.class);
  }
}
