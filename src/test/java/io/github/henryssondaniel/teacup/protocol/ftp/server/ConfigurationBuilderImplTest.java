package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ConfigurationBuilderImplTest {
  @InjectMocks
  private final ConfigurationBuilder configurationBuilder = new ConfigurationBuilderImpl();

  @Mock private ConfigurationSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new ConfigurationBuilderImpl().createImplementation())
        .isExactlyInstanceOf(ConfigurationImpl.class);
  }

  @Test
  void setClientConfiguration() {
    var clientConfiguration = mock(ClientConfiguration.class);
    configurationBuilder.setClientConfiguration(clientConfiguration);
    verify(implementation).setClientConfiguration(clientConfiguration);
  }

  @Test
  void setIdleTimeout() {
    configurationBuilder.setIdleTimeout(1);
    verify(implementation).setIdleTimeout(1);
  }

  @Test
  void setImplicitSsl() {
    configurationBuilder.setImplicitSsl(true);
    verify(implementation).setImplicitSsl(true);
  }

  @Test
  void setPort() {
    configurationBuilder.setPort(1);
    verify(implementation).setPort(1);
  }

  @Test
  void setServerAddress() {
    var serverAddress = "serverAddress";
    configurationBuilder.setServerAddress(serverAddress);
    verify(implementation).setServerAddress(serverAddress);
  }

  @Test
  void setSslConfiguration() {
    var sslConfiguration = mock(SslConfiguration.class);
    configurationBuilder.setSslConfiguration(sslConfiguration);
    verify(implementation).setSslConfiguration(sslConfiguration);
  }
}
