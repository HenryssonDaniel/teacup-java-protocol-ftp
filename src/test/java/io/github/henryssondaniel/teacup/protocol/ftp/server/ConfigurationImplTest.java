package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class ConfigurationImplTest {
  private final ConfigurationSetter configurationSetter = new ConfigurationImpl();

  @Test
  void getClientConfiguration() {
    assertThat(configurationSetter.getClientConfiguration()).isNull();
  }

  @Test
  void getIdleTimeout() {
    assertThat(configurationSetter.getIdleTimeout()).isNull();
  }

  @Test
  void getPort() {
    assertThat(configurationSetter.getPort()).isNull();
  }

  @Test
  void getServerAddress() {
    assertThat(configurationSetter.getServerAddress()).isNull();
  }

  @Test
  void getSslConfiguration() {
    assertThat(configurationSetter.getSslConfiguration()).isNull();
  }

  @Test
  void hasImplicitSsl() {
    assertThat(configurationSetter.hasImplicitSsl()).isFalse();
  }

  @Test
  void setAndGetClientConfiguration() {
    var clientConfiguration = mock(ClientConfiguration.class);
    configurationSetter.setClientConfiguration(clientConfiguration);
    assertThat(configurationSetter.getClientConfiguration()).isSameAs(clientConfiguration);
  }

  @Test
  void setAndGetIdleTimeout() {
    configurationSetter.setIdleTimeout(1);
    assertThat(configurationSetter.getIdleTimeout()).isOne();
  }

  @Test
  void setAndGetImplicitSsl() {
    configurationSetter.setImplicitSsl(true);
    assertThat(configurationSetter.hasImplicitSsl()).isTrue();
  }

  @Test
  void setAndGetPort() {
    configurationSetter.setPort(1);
    assertThat(configurationSetter.getPort()).isOne();
  }

  @Test
  void setAndGetServerAddress() {
    var serverAddress = "serverAddress";
    configurationSetter.setServerAddress(serverAddress);
    assertThat(configurationSetter.getServerAddress()).isEqualTo(serverAddress);
  }

  @Test
  void setAndGetSslConfiguration() {
    var sslConfiguration = mock(SslConfiguration.class);
    configurationSetter.setSslConfiguration(sslConfiguration);
    assertThat(configurationSetter.getSslConfiguration()).isSameAs(sslConfiguration);
  }
}
