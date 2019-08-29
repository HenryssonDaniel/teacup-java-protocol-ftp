package io.github.henryssondaniel.teacup.protocol.ftp.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.security.NoSuchAlgorithmException;
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
  void createSecureClientSslContext() throws NoSuchAlgorithmException {
    assertThat(Factory.createSecureClient(false, SSLContext.getDefault()))
        .isExactlyInstanceOf(Secure.class);
  }

  @Test
  void createSecureClientWithProtocol() {
    assertThat(Factory.createSecureClient(false, "SSL")).isExactlyInstanceOf(Secure.class);
  }
}
