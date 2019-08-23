package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ClientConfigurationBuilderImplTest {

  @InjectMocks
  private final ClientConfigurationBuilder clientConfigurationBuilder =
      new ClientConfigurationBuilderImpl();

  @Mock private ClientConfigurationSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new ClientConfigurationBuilderImpl().createImplementation())
        .isExactlyInstanceOf(ClientConfigurationImpl.class);
  }

  @Test
  void setActiveEnabled() {
    clientConfigurationBuilder.setActiveEnabled(true);
    verify(implementation).setActiveEnabled(true);
  }

  @Test
  void setActiveIpCheck() {
    clientConfigurationBuilder.setActiveIpCheck(true);
    verify(implementation).setActiveIpCheck(true);
  }

  @Test
  void setActiveLocalAddress() {
    var activeLocalAddress = "activeLocalAddress";
    clientConfigurationBuilder.setActiveLocalAddress(activeLocalAddress);
    verify(implementation).setActiveLocalAddress(activeLocalAddress);
  }

  @Test
  void setActiveLocalPort() {
    var activeLocalPort = 1;
    clientConfigurationBuilder.setActiveLocalPort(activeLocalPort);
    verify(implementation).setActiveLocalPort(activeLocalPort);
  }

  @Test
  void setIdleTime() {
    var idleTime = 1;
    clientConfigurationBuilder.setIdleTime(idleTime);
    verify(implementation).setIdleTime(idleTime);
  }

  @Test
  void setImplicitSsl() {
    clientConfigurationBuilder.setImplicitSsl(true);
    verify(implementation).setImplicitSsl(true);
  }

  @Test
  void setPassiveAddress() {
    var passiveAddress = "passiveAddress";
    clientConfigurationBuilder.setPassiveAddress(passiveAddress);
    verify(implementation).setPassiveAddress(passiveAddress);
  }

  @Test
  void setPassiveExternalAddress() {
    var passiveExternalAddress = "passiveExternalAddress";
    clientConfigurationBuilder.setPassiveExternalAddress(passiveExternalAddress);
    verify(implementation).setPassiveExternalAddress(passiveExternalAddress);
  }

  @Test
  void setPassiveIpCheck() {
    clientConfigurationBuilder.setPassiveIpCheck(true);
    verify(implementation).setPassiveIpCheck(true);
  }

  @Test
  void setPassivePorts() {
    var passivePorts = "passivePorts";
    clientConfigurationBuilder.setPassivePorts(passivePorts);
    verify(implementation).setPassivePorts(passivePorts);
  }

  @Test
  void setSslConfiguration() {
    var sslConfiguration = mock(SslConfiguration.class);
    clientConfigurationBuilder.setSslConfiguration(sslConfiguration);
    verify(implementation).setSslConfiguration(sslConfiguration);
  }
}
