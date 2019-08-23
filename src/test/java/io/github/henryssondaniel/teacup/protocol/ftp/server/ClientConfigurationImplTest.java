package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

class ClientConfigurationImplTest {
  private final ClientConfigurationSetter clientConfigurationSetter = new ClientConfigurationImpl();

  @Test
  void getActiveLocalAddress() {
    assertThat(clientConfigurationSetter.getActiveLocalAddress()).isNull();
  }

  @Test
  void getActiveLocalPort() {
    assertThat(clientConfigurationSetter.getActiveLocalPort()).isZero();
  }

  @Test
  void getIdleTime() {
    assertThat(clientConfigurationSetter.getIdleTime()).isNull();
  }

  @Test
  void getPassiveAddress() {
    assertThat(clientConfigurationSetter.getPassiveAddress()).isNull();
  }

  @Test
  void getPassiveExternalAddress() {
    assertThat(clientConfigurationSetter.getPassiveExternalAddress()).isNull();
  }

  @Test
  void getPassivePorts() {
    assertThat(clientConfigurationSetter.getPassivePorts()).isNull();
  }

  @Test
  void getSslConfiguration() {
    assertThat(clientConfigurationSetter.getSslConfiguration()).isNull();
  }

  @Test
  void hasActiveEnabled() {
    assertThat(clientConfigurationSetter.hasActiveEnabled()).isNull();
  }

  @Test
  void hasActiveIpCheck() {
    assertThat(clientConfigurationSetter.hasActiveIpCheck()).isFalse();
  }

  @Test
  void hasImplicitSsl() {
    assertThat(clientConfigurationSetter.hasImplicitSsl()).isFalse();
  }

  @Test
  void hasPassiveIpCheck() {
    assertThat(clientConfigurationSetter.hasPassiveIpCheck()).isFalse();
  }

  @Test
  void setAndGetActiveEnabled() {
    clientConfigurationSetter.setActiveEnabled(true);
    assertThat(clientConfigurationSetter.hasActiveEnabled()).isTrue();
  }

  @Test
  void setAndGetActiveIpCheck() {
    clientConfigurationSetter.setActiveIpCheck(true);
    assertThat(clientConfigurationSetter.hasActiveIpCheck()).isTrue();
  }

  @Test
  void setAndGetActiveLocalAddress() {
    var activeLocalAddress = "activeLocalAddress";
    clientConfigurationSetter.setActiveLocalAddress(activeLocalAddress);
    assertThat(clientConfigurationSetter.getActiveLocalAddress()).isEqualTo(activeLocalAddress);
  }

  @Test
  void setAndGetActiveLocalPort() {
    var activeLocalPort = 1;
    clientConfigurationSetter.setActiveLocalPort(activeLocalPort);
    assertThat(clientConfigurationSetter.getActiveLocalPort()).isEqualTo(activeLocalPort);
  }

  @Test
  void setAndGetIdleTime() {
    var idleTime = 1;
    clientConfigurationSetter.setIdleTime(idleTime);
    assertThat(clientConfigurationSetter.getIdleTime()).isEqualTo(idleTime);
  }

  @Test
  void setAndGetImplicitSsl() {
    clientConfigurationSetter.setImplicitSsl(true);
    assertThat(clientConfigurationSetter.hasImplicitSsl()).isTrue();
  }

  @Test
  void setAndGetPassiveAddress() {
    var passiveAddress = "passiveAddress";
    clientConfigurationSetter.setPassiveAddress(passiveAddress);
    assertThat(clientConfigurationSetter.getPassiveAddress()).isEqualTo(passiveAddress);
  }

  @Test
  void setAndGetPassiveExternalAddress() {
    var passiveExternalAddress = "passiveExternalAddress";
    clientConfigurationSetter.setPassiveExternalAddress(passiveExternalAddress);
    assertThat(clientConfigurationSetter.getPassiveExternalAddress())
        .isEqualTo(passiveExternalAddress);
  }

  @Test
  void setAndGetPassiveIpCheck() {
    clientConfigurationSetter.setPassiveIpCheck(true);
    assertThat(clientConfigurationSetter.hasPassiveIpCheck()).isTrue();
  }

  @Test
  void setAndGetPassivePorts() {
    var passivePorts = "passivePorts";
    clientConfigurationSetter.setPassivePorts(passivePorts);
    assertThat(clientConfigurationSetter.getPassivePorts()).isEqualTo(passivePorts);
  }

  @Test
  void setAndGetSslConfiguration() {
    var sslConfiguration = mock(SslConfiguration.class);
    clientConfigurationSetter.setSslConfiguration(sslConfiguration);
    assertThat(clientConfigurationSetter.getSslConfiguration()).isEqualTo(sslConfiguration);
  }
}
