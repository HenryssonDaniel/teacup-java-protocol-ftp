package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ClientConfigurationTest {
  private static final String ACTIVE_LOCAL_ADDRESS = "activeLocalAddress";
  private static final int ACTIVE_LOCAL_PORT = 1;
  private static final int IDLE_TIME = 1;
  private static final String PASSIVE_ADDRESS = "passiveAddress";
  private static final String PASSIVE_EXTERNAL_ADDRESS = "passiveExternalAddress";
  private static final String PASSIVE_PORTS = "passivePorts";
  private static final SslConfiguration SSL_CONFIGURATION =
      Factory.createSslConfigurationBuilder().build();

  @Test
  void createClientConfigurationBuilder() {
    var clientConfiguration =
        Factory.createClientConfigurationBuilder()
            .setActiveEnabled(true)
            .setActiveIpCheck(true)
            .setActiveLocalAddress(ACTIVE_LOCAL_ADDRESS)
            .setActiveLocalPort(ACTIVE_LOCAL_PORT)
            .setIdleTime(IDLE_TIME)
            .setImplicitSsl(true)
            .setPassiveAddress(PASSIVE_ADDRESS)
            .setPassiveExternalAddress(PASSIVE_EXTERNAL_ADDRESS)
            .setPassiveIpCheck(true)
            .setPassivePorts(PASSIVE_PORTS)
            .setSslConfiguration(SSL_CONFIGURATION)
            .build();

    assertThat(clientConfiguration.getActiveLocalAddress()).isEqualTo(ACTIVE_LOCAL_ADDRESS);
    assertThat(clientConfiguration.getActiveLocalPort()).isEqualTo(ACTIVE_LOCAL_PORT);
    assertThat(clientConfiguration.getIdleTime()).isEqualTo(IDLE_TIME);
    assertThat(clientConfiguration.getPassiveAddress()).isEqualTo(PASSIVE_ADDRESS);
    assertThat(clientConfiguration.getPassiveExternalAddress()).isEqualTo(PASSIVE_EXTERNAL_ADDRESS);
    assertThat(clientConfiguration.getPassivePorts()).isEqualTo(PASSIVE_PORTS);
    assertThat(clientConfiguration.getSslConfiguration()).isSameAs(SSL_CONFIGURATION);
    assertThat(clientConfiguration.hasActiveEnabled()).isTrue();
    assertThat(clientConfiguration.hasActiveIpCheck()).isTrue();
    assertThat(clientConfiguration.hasImplicitSsl()).isTrue();
    assertThat(clientConfiguration.hasPassiveIpCheck()).isTrue();
  }
}
