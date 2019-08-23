package io.github.henryssondaniel.teacup.protocol.ftp.server;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SslConfigurationBuilderImplTest {
  private final File file = mock(File.class);

  @InjectMocks
  private final SslConfigurationBuilder sslConfigurationBuilder = new SslConfigurationBuilderImpl();

  @Mock private SslConfigurationSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new SslConfigurationBuilderImpl().createImplementation())
        .isExactlyInstanceOf(SslConfigurationImpl.class);
  }

  @Test
  void setAndGetClientAuthentication() {
    var clientAuthentication = "clientAuthentication";
    sslConfigurationBuilder.setClientAuthentication(clientAuthentication);
    verify(implementation).setClientAuthentication(clientAuthentication);
  }

  @Test
  void setAndGetEnabledCipherSuites() {
    var enabledCipherSuites = "enabledCipherSuites";
    sslConfigurationBuilder.setEnabledCipherSuites(enabledCipherSuites);
    verify(implementation).setEnabledCipherSuites(enabledCipherSuites);
  }

  @Test
  void setAndGetKeyAlias() {
    var keyAlias = "keyAlias";
    sslConfigurationBuilder.setKeyAlias(keyAlias);
    verify(implementation).setKeyAlias(keyAlias);
  }

  @Test
  void setAndGetKeyPassword() {
    var keyPassword = "keyPassword";
    sslConfigurationBuilder.setKeyPassword(keyPassword);
    verify(implementation).setKeyPassword(keyPassword);
  }

  @Test
  void setAndGetKeystoreAlgorithm() {
    var keystoreAlgorithm = "keystoreAlgorithm";
    sslConfigurationBuilder.setKeystoreAlgorithm(keystoreAlgorithm);
    verify(implementation).setKeystoreAlgorithm(keystoreAlgorithm);
  }

  @Test
  void setAndGetKeystoreFile() {
    sslConfigurationBuilder.setKeystoreFile(file);
    verify(implementation).setKeystoreFile(file);
  }

  @Test
  void setAndGetKeystorePassword() {
    var keystorePassword = "keystorePassword";
    sslConfigurationBuilder.setKeystorePassword(keystorePassword);
    verify(implementation).setKeystorePassword(keystorePassword);
  }

  @Test
  void setAndGetKeystoreType() {
    var keystoreType = "keystoreType";
    sslConfigurationBuilder.setKeystoreType(keystoreType);
    verify(implementation).setKeystoreType(keystoreType);
  }

  @Test
  void setAndGetSslProtocol() {
    var sslProtocol = "sslProtocol";
    sslConfigurationBuilder.setSslProtocol(sslProtocol);
    verify(implementation).setSslProtocol(sslProtocol);
  }

  @Test
  void setAndGetTruststoreAlgorithm() {
    var truststoreAlgorithm = "truststoreAlgorithm";
    sslConfigurationBuilder.setTruststoreAlgorithm(truststoreAlgorithm);
    verify(implementation).setTruststoreAlgorithm(truststoreAlgorithm);
  }

  @Test
  void setAndGetTruststoreFile() {
    sslConfigurationBuilder.setTruststoreFile(file);
    verify(implementation).setTruststoreFile(file);
  }

  @Test
  void setAndGetTruststorePassword() {
    var truststorePassword = "truststorePassword";
    sslConfigurationBuilder.setTruststorePassword(truststorePassword);
    verify(implementation).setTruststorePassword(truststorePassword);
  }

  @Test
  void setAndGetTruststoreType() {
    var truststoreType = "truststoreType";
    sslConfigurationBuilder.setTruststoreType(truststoreType);
    verify(implementation).setTruststoreType(truststoreType);
  }
}
