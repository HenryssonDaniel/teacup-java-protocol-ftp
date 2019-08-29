package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConfigurationTest {
  private static final ClientConfiguration CLIENT_CONFIGURATION =
      Factory.createClientConfigurationBuilder().build();
  private static final int IDLE_TIMEOUT = 1;
  private static final int PORT = 1;
  private static final String SERVER_ADDRESS = "serverAddress";
  private static final SslConfiguration SSL_CONFIGURATION =
      Factory.createSslConfigurationBuilder().build();

  @Test
  void createConfigurationBuilder() {
    var configuration =
        Factory.createConfigurationBuilder()
            .setClientConfiguration(CLIENT_CONFIGURATION)
            .setIdleTimeout(IDLE_TIMEOUT)
            .setImplicitSsl(true)
            .setPort(PORT)
            .setServerAddress(SERVER_ADDRESS)
            .setSslConfiguration(SSL_CONFIGURATION)
            .build();

    assertThat(configuration.getClientConfiguration()).isSameAs(CLIENT_CONFIGURATION);
    assertThat(configuration.getIdleTimeout()).isEqualTo(IDLE_TIMEOUT);
    assertThat(configuration.getPort()).isEqualTo(PORT);
    assertThat(configuration.getServerAddress()).isEqualTo(SERVER_ADDRESS);
    assertThat(configuration.getSslConfiguration()).isSameAs(SSL_CONFIGURATION);
    assertThat(configuration.hasImplicitSsl()).isTrue();
  }
}
